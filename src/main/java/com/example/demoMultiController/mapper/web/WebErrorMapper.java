package com.example.demoMultiController.mapper.web;

import com.example.demoMultiController.exception.ServiceErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class WebErrorMapper {
    public HttpStatus getHttpStatus(ServiceErrorCode errorCode) {
        switch (errorCode) {
            case ILLEGAL_INPUT:
                return HttpStatus.BAD_REQUEST;
            case INTERNAL_ERROR:
                return HttpStatus.INTERNAL_SERVER_ERROR;
            default:
                return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
