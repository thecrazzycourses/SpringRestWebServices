package com.carzzy.rahul.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@Aspect
public class AspectConfig {

    // Pointcut : execution(Return Type Package-Name.Class-Name.Method-Name(Argument))
    @Pointcut("execution(* com.carzzy.rahul.aop.business.*.*(..))")
    public void businessLayerExecution() {}


    @Before("businessLayerExecution()")
    // JoinPoint : Specific execution instance - If there are 100 methods then there are 100 JoinPoint
    // Spring Framework make sure it will execute at right time its called Weaving & this framework is called Weaver
    public void before(JoinPoint joinPoint) {
        // Advice : Is the logic that we write here
        // Aspect : Pointcut + Advice, what kind of method call i would intercept & what to do
        log.info("Before execution - {}", joinPoint);
    }



    @AfterReturning(value = "businessLayerExecution()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        log.info("{} returned with value {}", joinPoint, result);
    }



    @AfterThrowing(value = "businessLayerExecution()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        log.info("{} returned with exception {}", joinPoint, exception);
    }



    @After(value = "businessLayerExecution()")
    public void afterThrowing(JoinPoint joinPoint) {
        log.info("After execution {}", joinPoint);
    }



    @Around(value = "businessLayerExecution()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;

        log.info("Around : Time taken by {} is {}", joinPoint, timeTaken);
    }
}
