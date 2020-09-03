package com.example.demoMultiController.controller.web;

import com.example.demoMultiController.dto.ErrorDto;
import com.example.demoMultiController.exception.ServiceException;
import com.example.demoMultiController.mapper.web.WebErrorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class WebExceptionHandler {
    private final WebErrorMapper webErrorMapper;

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorDto> handle(ServiceException exception) {
        return ResponseEntity
                .status(webErrorMapper.getHttpStatus(exception.getErrorCode()))
                .body(
                        new ErrorDto(
                                exception.getErrorCode(),
                                exception.getMessage()
                        )
                );
    }
}
