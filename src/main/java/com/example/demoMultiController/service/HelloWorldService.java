package com.example.demoMultiController.service;

import com.example.demoMultiController.exception.ServiceErrorCode;
import com.example.demoMultiController.exception.ServiceException;
import com.example.demoMultiController.model.Result;
import com.example.demoMultiController.model.SumRequest;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    public Result sum(SumRequest sumRequest) {
        if (sumRequest.getFirstNumber() < 0) {
            throw new ServiceException(ServiceErrorCode.ILLEGAL_INPUT, "firstNumber < 0");
        }

        if (sumRequest.getSecondNumber() < 0) {
            throw new ServiceException(ServiceErrorCode.ILLEGAL_INPUT, "secondNumber < 0");
        }

        if (sumRequest.getFirstNumber() == 0 && sumRequest.getSecondNumber() == 0) {
            throw new ServiceException(ServiceErrorCode.INTERNAL_ERROR, "Something went wrong");
        }

        return new Result(sumRequest.getFirstNumber() + sumRequest.getSecondNumber());
    }
}
