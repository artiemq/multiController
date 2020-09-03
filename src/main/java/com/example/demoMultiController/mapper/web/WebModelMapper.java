package com.example.demoMultiController.mapper.web;

import com.example.demoMultiController.dto.ResultDto;
import com.example.demoMultiController.dto.SumRequestDto;
import com.example.demoMultiController.model.Result;
import com.example.demoMultiController.model.SumRequest;
import org.springframework.stereotype.Component;

@Component
public class WebModelMapper {
    public SumRequest toModel(SumRequestDto sumRequestDto) {
        return new SumRequest(
                sumRequestDto.getFirstNumber(),
                sumRequestDto.getSecondNumber()
        );
    }

    public ResultDto toDto(Result result) {
        return new ResultDto(result.getValue());
    }
}
