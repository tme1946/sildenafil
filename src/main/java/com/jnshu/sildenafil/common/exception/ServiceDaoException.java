package com.jnshu.sildenafil.common.exception;

/**
 * #Title: ServiceDaoException
 * #ProjectName sildenafil
 * #Description: TODO
 * #author lihoo
 * #date 2018/11/8-21:29
 */


public class ServiceDaoException extends Exception {
    public ServiceDaoException() {
        super();
    }

    public ServiceDaoException(String message) {
        super(message);
    }

    public ServiceDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceDaoException(Throwable cause) {
        super(cause);
    }

    protected ServiceDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
