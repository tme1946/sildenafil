package com.jnshu.sildenafil.common.exception;

/**
 * #Title: ParamIsNullException
 * #ProjectName sildenafil
 * #Description: 参数为空时抛出错误
 * #author lihoo
 * #date 2018/11/9-9:33
 * @author lihoo
 */

@SuppressWarnings("unused")
public class ParamIsNullException extends Exception {
    public ParamIsNullException() {
        super();
    }

    public ParamIsNullException(String message) {
        super(message);
    }

    public ParamIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamIsNullException(Throwable cause) {
        super(cause);
    }

    protected ParamIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
