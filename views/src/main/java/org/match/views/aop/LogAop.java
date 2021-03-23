package org.match.views.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAop {
    @Pointcut("execution(* org.match.views.controller.*.doResp*(..))")
    public void logPc(){}

}
