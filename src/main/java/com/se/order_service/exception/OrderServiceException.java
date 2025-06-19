package com.se.order_service.exception;

public class OrderServiceException extends RuntimeException {
    public OrderServiceException() {
    }

    public OrderServiceException(String message) {
        super(message);
    }

    public OrderServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderServiceException(Throwable cause) {
        super(cause);
    }

    public OrderServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
