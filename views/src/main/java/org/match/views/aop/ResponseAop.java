package org.match.views.aop;

import org.apache.commons.lang3.ObjectUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.match.views.utils.WebResponse;
import org.nrocn.lib.baserqnp.IMicroResponsable;
import org.nrocn.lib.baserqnp.ResultCode;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.match.domains.dto.DataTranslateObject;
import org.match.views.log.Logger;

import java.util.Objects;

@Aspect
@Component
public class ResponseAop {
    @Pointcut("execution(* org.match.views.controller.*.doResp*(..))")
    public void responsePc(){}



    private DataTranslateObject doRequestBefore(Object[] args) throws Throwable {
        //检查参数
        for (Object arg : args) {
            if( arg instanceof DataTranslateObject){
                  DataTranslateObject dto = (DataTranslateObject)arg;
                  dto.check();
                  return  dto;
            }

        }
        return  null;
    }


    @Around(value = "responsePc()")
    public IMicroResponsable doResponseAround(ProceedingJoinPoint joinPoint){
        long current = System.currentTimeMillis();
        try {
            Object result = null;
            DataTranslateObject dataTranslateObject = doRequestBefore(joinPoint.getArgs());
            if( Objects.isNull(dataTranslateObject) ||
                    (Objects.nonNull(dataTranslateObject) && dataTranslateObject.isPass())){
                 result = joinPoint.proceed();
            }
            else if(Objects.nonNull(dataTranslateObject) && !dataTranslateObject.isPass()){
                return  WebResponse.getPrototype().failedResp("参数错误", ResultCode.PARAM_VALID_ERROR,dataTranslateObject.getMessage());
            }
//            result = joinPoint.proceed();
            if(result instanceof IMicroResponsable){
                return (IMicroResponsable) result;
            }
            else{
                return ObjectUtils.isEmpty(result)?
                      WebResponse.getPrototype().failedResp("请求成功但返回为空", ResultCode.MSG_NOT_READABLE):
                        WebResponse.getPrototype().successResp("请求成功",result);
            }
        } catch (Throwable ex) {
            return  WebResponse.getPrototype().failedResp("请求失败", ResultCode.FAILURE,ex.getMessage());
        }
        finally {
            long useTime = System.currentTimeMillis() - current;
            //写日志
            Logger.write(joinPoint.getTarget() + "用时"+ useTime + "ms");
        }

    }
}
