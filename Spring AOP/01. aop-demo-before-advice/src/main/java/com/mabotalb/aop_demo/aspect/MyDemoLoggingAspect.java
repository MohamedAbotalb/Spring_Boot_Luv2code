package com.mabotalb.aop_demo.aspect;

import java.lang.classfile.MethodSignature;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mabotalb.aop_demo.Account;
    @Before("execution (public void addAccount())")
    public void beforeAddAccountAdvice() {

        System.out.println("\n======>>> Execution @Before advice on addAccount()");
    }
}
