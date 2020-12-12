package com.aegon.calculator.service.impl;

import com.aegon.calculator.service.CalculatorService;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

/**
 * The Calculator Service Implementation class
 *
 * @author ragesh
 */
@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double add(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public double subtract(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public double multiply(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public double divide(int num1, int num2) {
        if (num2 == 0) {
            throw new ValidationException("Divisor should not be zero");
        }
        return (double) num1 / num2;
    }
}
