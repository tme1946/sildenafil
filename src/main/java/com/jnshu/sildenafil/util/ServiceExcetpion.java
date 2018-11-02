package com.jnshu.sildenafil.util;

public class ServiceExcetpion extends Exception{

    public ServiceExcetpion() {
        super();
    }

    public ServiceExcetpion(String message) {
        super(message);
    }

    public ServiceExcetpion(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceExcetpion(Throwable cause) {
        super(cause);
    }

    protected ServiceExcetpion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
