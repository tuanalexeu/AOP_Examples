package com.example.aop.throwsAdvice;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception ex) {
        System.out.println("***");
        System.out.println("Generic Exception Capture");
        System.out.println("***\n");
    }

    public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException ex) {
        System.out.println("***");
        System.out.println("IllegalArgumentException Capture");
        System.out.println("Method: " + method.getName());
        System.out.println("***\n");
    }

    public static void main(String[] args) throws Exception {
        ErrorBean bean = new ErrorBean();

        ProxyFactory pf = new ProxyFactory();

        pf.addAdvice(new SimpleThrowsAdvice());
        pf.setTarget(bean);

        ErrorBean bean1 = (ErrorBean) pf.getProxy();
        bean1.otherErrorPhoneMethod();
    }
}
