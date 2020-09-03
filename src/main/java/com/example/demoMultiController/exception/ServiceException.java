package com.example.demoMultiController.exception;

public class ServiceException extends RuntimeException {
    private final String message;
    private final ServiceErrorCode serviceErrorCode;

    public ServiceException(ServiceErrorCode errorCode, String message) {
        super(message);
        this.serviceErrorCode = errorCode;
        this.message = message;
    }

    public ServiceErrorCode getErrorCode() {
        return serviceErrorCode;
    };

    public String getMessage() {
        return message;
    };
}
