package com.example.demoMultiController;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestHelloWorldThriftController {
    @Autowired
    protected TProtocolFactory protocolFactory;
    @LocalServerPort
    protected int port;

    protected THelloWorldService.Client client;

    @BeforeEach
    public void setUp() throws Exception {
        TTransport transport = new THttpClient("http://localhost:" + port + "/thrift");

        TProtocol protocol = protocolFactory.getProtocol(transport);

        client = new THelloWorldService.Client(protocol);
    }

    @Test
    void shouldReturnSumOfTwoPositiveNumbers() throws TException {
        TResult result = client.sum(new TSumRequest(1, 1));

        assertEquals(2, result.getValue());
    }

    @Test
    void shouldThrowExceptionOnSumOfNegativeNumbers() {
        TServiceException exception = assertThrows(TServiceException.class, () -> client.sum(new TSumRequest(-1, 1)));

        assertEquals(TServiceErrorCode.ILLEGAL_INPUT, exception.getErrorCode());
        assertEquals("firstNumber < 0", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionOnSumOfZeros() {
        TServiceException exception = assertThrows(TServiceException.class, () -> client.sum(new TSumRequest(0, 0)));

        assertEquals(TServiceErrorCode.INTERNAL_ERROR, exception.getErrorCode());
        assertEquals("Something went wrong", exception.getMessage());
    }
}

