package com.example.demoMultiController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestHelloWorldWebController {
    private final String REQUEST_BODY = "{\"first_number\" : \"%d\", \"second_number\": \"%s\"}";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnSumOfTwoPositiveNumbers() throws Exception {
        mockMvc.perform(
                post("/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.format(REQUEST_BODY, 1, 1))
        )
                .andExpect(jsonPath("$.result").value(2));
    }

    @Test
    void shouldThrowExceptionOnSumOfNegativeNumbers() throws Exception {
        mockMvc.perform(
                post("/sum")
                        .content(String.format(REQUEST_BODY, -11, 1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().is(400))
                .andExpect(jsonPath("$.error_code").value("ILLEGAL_INPUT"))
                .andExpect(jsonPath("$.error_message").value("firstNumber < 0"));
    }

    @Test
    void shouldThrowExceptionOnSumOfZeros() throws Exception {
        mockMvc.perform(
                post("/sum")
                        .content(String.format(REQUEST_BODY, 0, 0))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().is(500))
                .andExpect(jsonPath("$.error_code").value("INTERNAL_ERROR"))
                .andExpect(jsonPath("$.error_message").value("Something went wrong"));
    }
}
