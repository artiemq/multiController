package com.example.demoMultiController.controller.thrift;

import com.example.demoMultiController.THelloWorldService;
import com.example.demoMultiController.TResult;
import com.example.demoMultiController.TServiceException;
import com.example.demoMultiController.TSumRequest;
import com.example.demoMultiController.exception.ServiceException;
import com.example.demoMultiController.mapper.thrift.ThriftErrorMapper;
import com.example.demoMultiController.mapper.thrift.ThriftModelMapper;
import com.example.demoMultiController.service.HelloWorldService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class HelloWorldThriftController implements THelloWorldService.Iface {
    private final HelloWorldService helloWorldService;
    private final ThriftModelMapper modelMapper;
    private final ThriftErrorMapper errorMapper;

    @Override
    public TResult sum(TSumRequest sumRequest) throws TServiceException {
        try {
            return modelMapper.toDto(helloWorldService.sum(modelMapper.toModel(sumRequest)));
        } catch (ServiceException exception) {
            throw errorMapper.toTException(exception);
        }
    }
}
