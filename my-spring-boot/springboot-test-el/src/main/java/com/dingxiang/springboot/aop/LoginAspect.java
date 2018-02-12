package com.dingxiang.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LoginAspect {

    @Pointcut("@annotation(com.dingxiang.springboot.aop.Action)")
    public void annotationPointCut(){}


    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){

        MethodSignature signature=(MethodSignature) joinPoint.getSignature();
        Method method=signature.getMethod();
        Action action=method.getAnnotation(Action.class);

        System.out.println("After-注解式拦截：" + action.name()+"；Method:"+method.getName());
    }


    @Before("execution(* com.dingxiang.springboot.aop.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){

        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
        Method method=methodSignature.getMethod();

        System.out.println("Before-方法规则式拦截:"+method.getName());
    }
}
