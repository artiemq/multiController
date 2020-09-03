package com.example.demoMultiController.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class ResultDto {
    @JsonProperty("result")
    public final int value;
}
