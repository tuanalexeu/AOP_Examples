package com.example.aop.throwsAdvice;

public class ErrorBean {
    public void errorPhoneMethod() throws Exception {
        throw new Exception("Generic exception");
    }

    public void otherErrorPhoneMethod() throws IllegalAccessError {
        throw new IllegalAccessError("IllegalArgument Exception");
    }
}
