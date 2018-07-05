package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class TestAspect {

    /**
     * 说明
     * @Aspect 指定一个类为切面类
     * @Pointcut("execution(* cn.itcast.e_aop_anno.*.*(..))")  指定切入点表达式
     * @Before("pointCut_()") 前置通知: 目标方法之前执行
     * @After("pointCut_()") 后置通知：目标方法之后执行（始终执行）
     * @AfterReturning("pointCut_()") 返回后通知： 执行方法结束前执行(异常不执行)
     * @AfterThrowing("pointCut_()") 异常通知:  出现异常时候执行
     * @Around("pointCut_()") 环绕通知： 环绕目标方法执行
     */

    //定义切点
    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    private void controllerMethod(){}

    @Before("controllerMethod()")
    public void begin(JoinPoint joinPoint){

        System.out.println("before..."+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName()+" with param:"+ Arrays.toString(joinPoint.getArgs()));
    }

    @After("controllerMethod()")
    public void after(){
        System.out.println("finish...");
    }

}
