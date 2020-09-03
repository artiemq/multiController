package com.example.demoMultiController.controller.web;

import com.example.demoMultiController.dto.ResultDto;
import com.example.demoMultiController.dto.SumRequestDto;
import com.example.demoMultiController.mapper.web.WebModelMapper;
import com.example.demoMultiController.service.HelloWorldService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloWordWebController {

    private final HelloWorldService helloWorldService;
    private final WebModelMapper modelMapper;

    @PostMapping("/sum")
    public ResultDto sum(@RequestBody SumRequestDto sumRequestDto) {
        return modelMapper.toDto(helloWorldService.sum(modelMapper.toModel(sumRequestDto)));
    }
}
