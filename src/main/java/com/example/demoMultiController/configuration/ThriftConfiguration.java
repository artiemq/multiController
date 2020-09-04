package com.example.demoMultiController.configuration;

import com.example.demoMultiController.THelloWorldService;
import com.example.demoMultiController.controller.thrift.HelloWorldThriftController;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

@Configuration
public class ThriftConfiguration {
    @Bean
    public TProtocolFactory tProtocolFactory() {
        return new TBinaryProtocol.Factory();
    }

    @Bean
    public ServletRegistrationBean<Servlet> thrift(TProtocolFactory protocolFactory, HelloWorldThriftController handler) {
        Servlet servlet = new TServlet(new THelloWorldService.Processor<>(handler), protocolFactory);
        return new ServletRegistrationBean<>(servlet, "/thrift");
    }
}
