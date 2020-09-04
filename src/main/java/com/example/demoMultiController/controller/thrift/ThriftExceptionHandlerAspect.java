package com.example.demoMultiController.controller.thrift;

import com.example.demoMultiController.exception.ServiceException;
import com.example.demoMultiController.mapper.thrift.ThriftErrorMapper;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@RequiredArgsConstructor
public class ThriftExceptionHandlerAspect {
    private final ThriftErrorMapper errorMapper;

    @Around("within(@com.example.demoMultiController.controller.thrift.ThriftController *) && execution(public * *(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (ServiceException exception) {
            throw errorMapper.toTException(exception);
        }
    }
}
