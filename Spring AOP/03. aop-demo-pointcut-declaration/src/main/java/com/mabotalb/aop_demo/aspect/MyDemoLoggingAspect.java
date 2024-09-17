package com.mabotalb.aop_demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // This is where we add all of our related advices for logging
    // let's start with the @Before advice

    // Pointcut Declaration

    @Pointcut("execution (* com.mabotalb.aop_demo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n======>>> Execution @Before advice on addAccount()");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {

        System.out.println("\n======>>> Performing API Analytics");
    }
}
