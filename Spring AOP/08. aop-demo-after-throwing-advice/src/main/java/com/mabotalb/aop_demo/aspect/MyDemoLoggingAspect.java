package com.mabotalb.aop_demo.aspect;

import java.util.List;

import com.mabotalb.aop_demo.Account;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

    // AfterThrowing Advice

    @AfterThrowing(
        pointcut="execution(* com.mabotalb.aop_demo.dao.AccountDAO.findAccounts(..))",
        throwing="exc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {

        // Print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @AfterThrowing advice on method " + method);

        // Log the exception
        System.out.println("\n=======>>> Exception is: " + exc);
    }

    @AfterReturning(
        pointcut="execution(* com.mabotalb.aop_demo.dao.AccountDAO.findAccounts(..))",
        returning="result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        // Print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @AfterReturning advice on method " + method);

        // Print out the result of the method call
        System.out.println("\n=======>>> result is: " + result);

        // Let's post-process the data

        // Convert account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n=======>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        
        for (Account account : result) {

            String upperName = account.getName().toUpperCase();

            account.setName(upperName);
        }
    }

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
