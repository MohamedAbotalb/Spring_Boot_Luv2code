package com.mabotalb.aop_demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // This is where we add all of our related advices for logging
    // let's start with the @Before advice

    // PointCut Expressions
    // Match any method with name of addAccount
    // @Before("execution (public void addAccount())")

    // Match not found method
    // @Before("execution (public void updateAccount())")

    // Match only specific method with name of addAccount from AccountDAO Interface
    // @Before("execution (public void com.abotalb.aop_demo.AccountDAO.addAccount())")

    // Match any method starting with 'add'
    // @Before("execution (public void add*())")

    // Match any method with any return type
    // @Before("execution (* add*())")

    // Match any method with any return type with Account argument type
    // @Before("execution (* add*(com.mabotalb.aop_demo.Account))")

    // Match any method with any return type with Account argument and any number of arguments (..)
    // @Before("execution (* add*(com.mabotalb.aop_demo.Account, ..))") (..) any number of arguments zero to many

    // Match any method with any return type with any number of arguments
    // @Before("execution (* add*(..))")

    // Match any method in the package dao with any number of arguments
    // @Before("execution (* com.mabotalb.aop_demo.dao.*.*(..))")

    @Before("execution (* com.mabotalb.aop_demo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {

        System.out.println("\n======>>> Execution @Before advice on addAccount()");
    }
}
