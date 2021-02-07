package com.example.aop.afterAdvice;

import com.example.aop.aroundAdvice.WorkerBean;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

public class ProfilingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start(invocation.getMethod().getName());

        Object returnValue = invocation.proceed();

        stopWatch.stop();
        dumpInfo(invocation, stopWatch.getTotalTimeMillis());

        return returnValue;
    }

    private void dumpInfo(MethodInvocation invocation, long totalTimeMillis) {
        Method m = invocation.getMethod();
        Object target = invocation.getThis();
        Object args = invocation.getArguments();

        System.out.println("Executed method: " + m.getName());
        System.out.println("On object of type: " + target.getClass().getSimpleName());
        System.out.println("With arguments: " + args);

        System.out.println("\n");
        System.out.println("Took: " + totalTimeMillis + " ms");
    }

    public static void main(String[] args) {
        WorkerBean bean = getWorkerBean();
        bean.doSomeWork(100000);
    }

    private static WorkerBean getWorkerBean() {
        WorkerBean target = new WorkerBean();
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvice(new ProfilingInterceptor());

        return (WorkerBean) pf.getProxy();
    }
}
