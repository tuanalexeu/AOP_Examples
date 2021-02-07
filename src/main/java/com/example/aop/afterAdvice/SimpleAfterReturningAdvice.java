package com.example.aop.afterAdvice;

import com.example.aop.Guitarist;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("After advice is in work");
    }

    public static void main(String[] args) {
        Guitarist guitarist = new Guitarist();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(guitarist);
        pf.addAdvice(new SimpleAfterReturningAdvice());

        ((Guitarist) pf.getProxy()).sing();
    }
}
