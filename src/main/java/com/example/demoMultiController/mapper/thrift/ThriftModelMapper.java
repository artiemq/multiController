package com.example.demoMultiController.mapper.thrift;

import com.example.demoMultiController.TResult;
import com.example.demoMultiController.TSumRequest;
import com.example.demoMultiController.model.Result;
import com.example.demoMultiController.model.SumRequest;
import org.springframework.stereotype.Component;

@Component
public class ThriftModelMapper {
    public SumRequest toModel(TSumRequest sumRequest) {
        return new SumRequest(
                sumRequest.getFirstNumber(),
                sumRequest.getSecondNumber()
        );
    }

    public TResult toDto(Result result) {
        return new TResult(result.getValue());
    }
}
