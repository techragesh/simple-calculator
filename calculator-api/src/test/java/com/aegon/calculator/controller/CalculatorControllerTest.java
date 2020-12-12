package com.aegon.calculator.controller;

import com.aegon.calculator.exception.CalculatorServiceException;
import com.aegon.calculator.model.Result;
import com.aegon.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import javax.validation.ValidationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {

    @InjectMocks
    private CalculatorController calculatorController;

    @Mock
    private CalculatorService calculatorService;

    @Captor
    private ArgumentCaptor<Integer> argumentCaptor1;

    @Captor
    private ArgumentCaptor<Integer> argumentCaptor2;

    @Test
    public void add() {
        Mockito.when(calculatorService.add(argumentCaptor1.capture(),argumentCaptor2.capture())).thenReturn(5.0);
        ResponseEntity<Result> responseEntity = calculatorController.add(3,2);
        assertEquals(5.0, responseEntity.getBody().getResult());
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void subtract() {
        Mockito.when(calculatorService.subtract(argumentCaptor1.capture(),argumentCaptor2.capture())).thenReturn(8.0);
        ResponseEntity<Result> responseEntity = calculatorController.subtract(10,2);
        assertEquals(8.0, responseEntity.getBody().getResult());
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void multiply() {
        Mockito.when(calculatorService.multiply(argumentCaptor1.capture(),argumentCaptor2.capture())).thenReturn(6.0);
        ResponseEntity<Result> responseEntity = calculatorController.multiply(3,2);
        assertEquals(6.0, responseEntity.getBody().getResult());
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void divide() {
        Mockito.when(calculatorService.divide(argumentCaptor1.capture(),argumentCaptor2.capture())).thenReturn(2.0);
        ResponseEntity<Result> responseEntity = calculatorController.divide(10,5);
        assertEquals(2.0, responseEntity.getBody().getResult());
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void dividebyZero() {
        try {
            Mockito.when(calculatorService.divide(argumentCaptor1.capture(), argumentCaptor2.capture())).thenThrow(ValidationException.class);
            ResponseEntity<Result> responseEntity = calculatorController.divide(3, 0);
            fail();
        }catch (ValidationException e) {
            assertTrue(e instanceof ValidationException);
        }
    }

    @Test
    public void addInvalidInput() {
        try {
            Mockito.when(calculatorService.add(argumentCaptor1.capture(), argumentCaptor2.capture())).thenThrow(NumberFormatException.class);
            ResponseEntity<Result> responseEntity = calculatorController.add(3, 2);
            fail();
        }catch (NumberFormatException e) {
            assertTrue(e instanceof NumberFormatException);
        }
    }

    @Test
    public void addServerError() {
        try {
            Mockito.when(calculatorService.add(argumentCaptor1.capture(), argumentCaptor2.capture())).thenThrow(CalculatorServiceException.class);
            ResponseEntity<Result> responseEntity = calculatorController.add(3, 2);
            fail();
        }catch (CalculatorServiceException e) {
            assertTrue(e instanceof CalculatorServiceException);
        }
    }
}
