package com.mabotalb.mvc_crud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    // Setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // Setup pointcut declarations
    // For controller package
    @Pointcut("execution(* com.mabotalb.mvc_crud.controller.*.*(..)")
    public void forControllerPackage() {}

    // For dao package
    @Pointcut("execution(* com.mabotalb.mvc_crud.dao.*.*(..)")
    public void forDAOPackage() {}

    // For service package
    @Pointcut("execution(* com.mabotalb.mvc_crud.service.*.*(..)")
    public void forServicePackage() {}

    // Combine pointcut declarations
    @Pointcut("forControllerPackage() || forDAOPackage() || forServicePackage()")
    private  void forAppFlow() {}

    // Add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        // Display method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====>> in @Before: calling method: " + method);

        // Get the arguments from the method
        Object[] args = joinPoint.getArgs();

        // Loop through the arguments
        for (Object arg : args) {
            logger.info("=====>> argument: " + arg);
        }
    }

    // Add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {

        // Display method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====>> in @AfterReturning: calling method: " + method);

        // Display the result of the method call
        logger.info("=====>> result is: " + result);
    }
}

