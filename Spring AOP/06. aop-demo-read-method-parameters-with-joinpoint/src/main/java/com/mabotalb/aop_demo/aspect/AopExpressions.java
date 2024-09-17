package com.mabotalb.aop_demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution (* com.mabotalb.aop_demo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    // Create a pointcut for setter methods
    @Pointcut("execution (* com.mabotalb.aop_demo.dao.*.set*(..))")
    public void setter() {
    }

    // Create a pointcut for getter methods
    @Pointcut("execution (* com.mabotalb.aop_demo.dao.*.get*(..))")
    public void getter() {
    }

    // Combine pointcut: package and exclude getter/setter
    @Pointcut("forDaoPackage() && !(setter() || getter())")
    public void forDaoPackageNoSetterGetter() {
    }
}
