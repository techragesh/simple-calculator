package com.aegon.calculator.service;

import com.aegon.calculator.service.impl.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ValidationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

    @InjectMocks
    private CalculatorServiceImpl calculatorService;

    @Test
    public void testAdd() {
        double result = calculatorService.add(1, 2);
        assertEquals(3, result);
    }

    @Test
    public void testSubtract() {
        double result = calculatorService.subtract(4, 2);
        assertEquals(2, result);
    }

    @Test
    public void testMultiply() {
        double result = calculatorService.multiply(4, 2);
        assertEquals(8, result);
    }

    @Test
    public void testDivide() {
        double result = calculatorService.divide(4, 2);
        assertEquals(2, result);
    }

    @Test
    public void testDivideFraction() {
        double result = calculatorService.divide(9, 2);
        assertEquals(4.5, result);
    }

    @Test
    public void testDivideByZero() {
        try {
            double result = calculatorService.divide(4, 0);
            fail();
        } catch (ValidationException e) {
            assertTrue(e instanceof ValidationException);
        }
    }
}
