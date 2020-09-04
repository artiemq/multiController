package com.example.demoMultiController.controller.thrift;

import org.springframework.stereotype.Controller;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Controller
public @interface ThriftController {
}
