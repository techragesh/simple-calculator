package com.aegon.calculator.controller;

import com.aegon.calculator.model.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void add() throws Exception{
        Result result = new Result(6.0);
        mockMvc.perform(get("/api/v1/calc/add/{num1}/{num2}", 4,2)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(result)))
                .andExpect(status().isOk())
                .andExpect(content().json(json("{'result': 6.0}")));
    }

    @Test
    public void sub() throws Exception{
        Result result = new Result(3.0);
        mockMvc.perform(get("/api/v1/calc/sub/{num1}/{num2}", 5,2)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(result)))
                .andExpect(status().isOk())
                .andExpect(content().json(json("{'result': 3.0}")));
    }

    @Test
    public void multiply() throws Exception{
        Result result = new Result(10.0);
        mockMvc.perform(get("/api/v1/calc/multiply/{num1}/{num2}", 5,2)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(result)))
                .andExpect(status().isOk())
                .andExpect(content().json(json("{'result': 10.0}")));
    }

    @Test
    public void divide() throws Exception{
        Result result = new Result(8.0);
        mockMvc.perform(get("/api/v1/calc/divide/{num1}/{num2}", 16,2)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(result)))
                .andExpect(status().isOk())
                .andExpect(content().json(json("{'result': 8.0}")));
    }

    @Test
    public void divideByZero() throws Exception{
        mockMvc.perform(get("/api/v1/calc/divide/{num1}/{num2}", 6,0)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(null)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void addInvalid() throws Exception{
        mockMvc.perform(get("/api/v1/calc/add/{num1}/{num2}", 16,"test")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(null)))
                .andExpect(status().is4xxClientError());
    }

    public static String json(String singleQuotedJson) {
        return (singleQuotedJson).replaceAll("'", "\"");
    }
}
