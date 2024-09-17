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

    // Combining Pointcut Declaration

    @Pointcut("execution (* com.mabotalb.aop_demo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    // Create a pointcut for setter methods
    @Pointcut("execution (* com.mabotalb.aop_demo.dao.*.set*(..))")
    private void setter() {
    }

    // Create a pointcut for getter methods
    @Pointcut("execution (* com.mabotalb.aop_demo.dao.*.get*(..))")
    private void getter() {
    }

    // Combine pointcut: package and exclude getter/setter
    @Pointcut("forDaoPackage() && !(setter() || getter())")
    public void forDaoPackageNoSetterGetter() {
    }

    @Before("forDaoPackageNoSetterGetter()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n======>>> Execution @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoSetterGetter()")
    public void performApiAnalytics() {

        System.out.println("\n======>>> Performing API Analytics");
    }
}
