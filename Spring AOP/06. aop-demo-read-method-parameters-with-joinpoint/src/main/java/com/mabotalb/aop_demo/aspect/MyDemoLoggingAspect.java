package com.mabotalb.aop_demo.aspect;

import com.mabotalb.aop_demo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // This is where we add all of our related advices for logging
    // let's start with the @Before advice

    // Read Method Arguments with JoinPoint

    @Before("com.mabotalb.aop_demo.aspect.AopExpressions.forDaoPackageNoSetterGetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        System.out.println("\n======>>> Execution @Before advice on addAccount()");

        // Display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method Signature: " + methodSignature);

        // Display the method arguments

        // Get the method arguments
        Object[] args = joinPoint.getArgs();

        // Loop through the method arguments
        for (Object arg : args) {
            System.out.println("Argument: " + arg);

            if (arg instanceof Account) {
                // Downcast and print Account specific stuff
                Account account = (Account) arg;

                System.out.println("Account Name: " + account.getName());
                System.out.println("Account Level: " + account.getLevel());
            }
        }
    }
}
