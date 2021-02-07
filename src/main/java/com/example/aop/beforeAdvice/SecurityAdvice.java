package com.example.aop.beforeAdvice;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvice(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        UserInfo user = securityManager.getLoggedOnUser();

        if(user == null) {
            System.out.println("No user authenticated");
        } else if(user.getUserName().equals("John")) {
            System.out.println("User authenticated");
        } else {
            throw new SecurityException("Illegal Access");
        }
    }

    public static void main(String[] args) {
        SecurityManager mgr = new SecurityManager();

        SecureBean bean = getSecureBean(mgr);
        mgr.login("Joh1", "pwd");
        bean.writeSecureMessage();
        mgr.logout();

    }

    private static SecureBean getSecureBean(SecurityManager mgr) {
        SecureBean target = new SecureBean();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);

        SecurityAdvice advice = new SecurityAdvice(mgr);
        factory.addAdvice(advice);

        return (SecureBean) factory.getProxy();
    }
}
