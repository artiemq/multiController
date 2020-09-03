package com.example.demoMultiController.dto;

import com.example.demoMultiController.exception.ServiceErrorCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class ErrorDto {
    @JsonProperty("error_code")
    private final ServiceErrorCode errorCode;

    @JsonProperty("error_message")
    private final String message;
}
