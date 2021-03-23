package org.match.views.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.match.views.log.Logger;


@Aspect
@Component
public class CultimeAop {


    @Pointcut("execution(* org.match.views.controller.*.*(..))")
    public void cultimePc(){}


    @Around("cultimePc()")
    public Object cultime(ProceedingJoinPoint proceedingJoinPoint){
        Object result = null;
        //计算执行时间
        long current = System.currentTimeMillis();
        try {
            result  =  proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
            throwable.printStackTrace();
        }
        long useTime = System.currentTimeMillis() - current;
        //写日志
        Logger.write(proceedingJoinPoint.getTarget() + "用时"+ useTime + "ms");
        return result;
    }


}
