package com.example.demoMultiController.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class SumRequestDto {
    @JsonProperty("first_number")
    private final int firstNumber;

    @JsonProperty("second_number")
    private final int secondNumber;
}
