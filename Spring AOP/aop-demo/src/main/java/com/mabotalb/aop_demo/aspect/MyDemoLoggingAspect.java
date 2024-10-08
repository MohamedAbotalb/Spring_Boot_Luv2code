package com.mabotalb.aop_demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // This is where we add all of our related advices for logging
    // let's start with the @Before advice

    @Before("execution (public void addAccount())")
    public void beforeAddAccountAdvice() {

        System.out.println("\n======>>> Execution @Before advice on addAccount()");
    }
}
