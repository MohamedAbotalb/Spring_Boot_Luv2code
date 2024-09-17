package com.mabotalb.aop_demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // This is where we add all of our related advices for logging
    // let's start with the @Before advice

    // Ordering Aspects

    @Before("com.mabotalb.aop_demo.aspect.AopExpressions.forDaoPackageNoSetterGetter()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n======>>> Execution @Before advice on addAccount()");
    }
}
