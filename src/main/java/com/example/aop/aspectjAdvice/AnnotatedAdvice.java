package com.example.aop.aspectjAdvice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotatedAdvice {

    @Pointcut("execution(* com.example.aop.aspectjAdvice..sing* (com.example.aop.aspectjAdvice.Guitar)) && args(value)")
    public void singExecution(Guitar value) {

    }

    @Pointcut("bean(johnMayer)")
    public void isJohn() {

    }

    @Before("singExecution(value) && isJohn()")
    public void simpleBeforeAdvice(JoinPoint joinPoint, Guitar value) {
        if(value.getBrand().equals("Gibson")) {
            System.out.println("Simple before advice");
        }
    }

    public void simpleAroundAdvice(ProceedingJoinPoint pjp, Guitar value) {
        System.out.println("Simple Around advice");
    }
}
