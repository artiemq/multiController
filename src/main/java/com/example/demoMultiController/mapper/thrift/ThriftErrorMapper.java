package com.example.demoMultiController.mapper.thrift;

import com.example.demoMultiController.TServiceErrorCode;
import com.example.demoMultiController.TServiceException;
import com.example.demoMultiController.exception.ServiceErrorCode;
import com.example.demoMultiController.exception.ServiceException;
import org.springframework.stereotype.Component;

@Component
public class ThriftErrorMapper {
    public TServiceException toTException(ServiceException exception) {
        return new TServiceException(
                toTErrorCode(exception.getErrorCode()),
                exception.getMessage()
        );
    }

    private TServiceErrorCode toTErrorCode(ServiceErrorCode errorCode) {
        switch (errorCode) {
            case ILLEGAL_INPUT:
                return TServiceErrorCode.ILLEGAL_INPUT;
            case INTERNAL_ERROR:
                return TServiceErrorCode.INTERNAL_ERROR;
            default:
                return TServiceErrorCode.INTERNAL_ERROR;
        }
    }
}
