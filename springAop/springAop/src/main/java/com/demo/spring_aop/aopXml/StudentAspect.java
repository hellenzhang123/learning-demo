package com.demo.spring_aop.aopXml;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类：注解的切面类
 * 
 */
public class StudentAspect {

    // 前置通知
    public void before() {
        System.out.println("前置增强===========");
    }

    // 后置通知:
    public void afterReturning(Object result) {
        System.out.println("后置增强===========" + result);
    }

    // 环绕通知:
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前增强==========");
        Object obj = joinPoint.proceed();
        System.out.println("环绕后增强==========");
        return obj;
    }

    // 异常抛出通知:
    public void afterThrowing(Throwable e) {
        System.out.println("异常抛出增强=========" + e.getMessage());
    }

    // 最终通知
    public void after() {
        System.out.println("最终增强============");
    }
}
