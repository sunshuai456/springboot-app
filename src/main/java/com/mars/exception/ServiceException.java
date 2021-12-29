package com.mars.exception;

import java.io.Serializable;

public class ServiceException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -9149154992275942096L;

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(String msg, Object... args) {
        super(String.format(msg, args));
    }

    public ServiceException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

}
