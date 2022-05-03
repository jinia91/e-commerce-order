package com.jinia.study.order.order.infra.log;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Slf4j
@RequiredArgsConstructor
@Component
public class LogAspect {

    private final LogTracer logTracer;

    @Around("execution(* com.jinia.study.order.order..*Controller.*(..))||execution(* com.jinia.study.order.order..*Queries.*(..))||execution(* com.jinia.study.order.order..*Service.*(..))||execution(* com.jinia.study.order.order..*Repository.*(..))||execution(* com.jinia.study.order.order..*Facade.*(..))")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        TraceStatusVO status = null;
        boolean hasException = false;
        try {
            status = logTracer.begin("Return:"+joinPoint.getSignature().toString(), Arrays.deepToString(joinPoint.getArgs()));
            return joinPoint.proceed();
        } catch (Exception ex) {
            logTracer.handleException(status, ex);
            hasException = true;
            throw ex;
        } finally {
            if(!hasException) logTracer.end(status);
        }
    }
}
