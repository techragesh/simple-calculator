package com.aegon.calculator.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CalculatorServiceExceptionTest {

    @Test
    public void calculatorServiceException() {
        try {
            throw new CalculatorServiceException();
        } catch (CalculatorServiceException are) {
            assertNull(are.getMessage());
            assertNull(are.getCause());
        }
    }

    @Test
    public void calculatorServiceExceptionMessage() {
        try {
            throw new CalculatorServiceException("Internal Server Error");
        } catch (CalculatorServiceException are) {
            assertEquals("Internal Server Error", are.getMessage());
            assertNull(are.getCause());
        }
    }

    @Test
    public void calculatorServiceExceptionSource() {
        try {
            throw new CalculatorServiceException(new RuntimeException());
        } catch (CalculatorServiceException are) {
            assertEquals("java.lang.RuntimeException", are.getCause().getClass().getName());
        }
    }

    @Test
    public void calculatorServiceExceptionMessageSource() {
        try {
            throw new CalculatorServiceException("Internal Server Error", new RuntimeException());
        } catch (CalculatorServiceException are) {
            assertEquals("java.lang.RuntimeException", are.getCause().getClass().getName());
            assertEquals("Internal Server Error", are.getMessage());
        }
    }
}
