package com.example.aop.aroundAdvice;

public class WorkerBean {
    public void doSomeWork(int n) {
        for (int i = 0; i < n; i++) {
            work();
        }
    }

    private void work() {
        System.out.print("");
    }
}
