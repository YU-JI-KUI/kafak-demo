package com.example.kafkademo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MethodLoggingAspect {

    @Around("execution(* your.package.name.service.*.*(..)) || execution(* your.package.name.controller.*.*(..))")
    public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        try {
            // Proceed with the method invocation
            Object result = joinPoint.proceed();

            // Log method exit
            logMethodExit(joinPoint, result, startTime);

            return result;
        } catch (Exception ex) {
            // Log exception if any
            log.error("Exception in method: " + joinPoint.getSignature().toShortString());
            log.error("Exception message: " + ex.getMessage());
            throw ex;
        }
    }

    private void logMethodExit(JoinPoint joinPoint, Object result, long startTime) {
        long executionTime = System.currentTimeMillis() - startTime;
        String exitLog = "Exiting method: " +
                "Class=" + joinPoint.getTarget().getClass().getName() +
                ", Method=" + joinPoint.getSignature().getName() +
                ", Args=" + getArguments(joinPoint) +
                ", Execution Time=" + executionTime + " ms" +
                ", Result=" + result;

        log.info(exitLog);
    }

    private String getArguments(JoinPoint joinPoint) {
        Object[] methodArgs = joinPoint.getArgs();
        StringBuilder arguments = new StringBuilder();

        for (Object arg : methodArgs) {
            arguments.append(arg).append(", ");
        }

        return arguments.toString();
    }

}
