package com.example.demoMultiController.controller.thrift;

import com.example.demoMultiController.THelloWorldService;
import com.example.demoMultiController.TResult;
import com.example.demoMultiController.TServiceException;
import com.example.demoMultiController.TSumRequest;
import com.example.demoMultiController.mapper.thrift.ThriftModelMapper;
import com.example.demoMultiController.service.HelloWorldService;
import lombok.RequiredArgsConstructor;

@ThriftController
@RequiredArgsConstructor
public class HelloWorldThriftController implements THelloWorldService.Iface {
    private final HelloWorldService helloWorldService;
    private final ThriftModelMapper modelMapper;

    @Override
    public TResult sum(TSumRequest sumRequest) throws TServiceException {
        return modelMapper.toDto(helloWorldService.sum(modelMapper.toModel(sumRequest)));
    }
}
