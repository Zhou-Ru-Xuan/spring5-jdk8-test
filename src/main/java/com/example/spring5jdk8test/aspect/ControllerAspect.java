package com.example.spring5jdk8test.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ControllerAspect {
    @AfterReturning(returning = "returnValue", pointcut = "execution(* com.example.spring5jdk8test.controller.*.*(..))")
    public void doAfterReturning(JoinPoint joinPoint, Object returnValue) {
        // JoinPoint无法序列化
        System.out.println(JSON.toJSONString(joinPoint));
    }
}
