package com.aegon.calculator.service.impl;

import com.aegon.calculator.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

/**
 * The Calculator Service Implementation class
 *
 * @author ragesh
 */
@Service
public class CalculatorServiceImpl implements CalculatorService {

    /**
     * Instantiates logging for this class
     */
    private static final Logger LOG = LoggerFactory.getLogger(CalculatorServiceImpl.class);

    @Override
    public double add(int num1, int num2) {
        LOG.info("Method in add");
        return num1 + num2;
    }

    @Override
    public double subtract(int num1, int num2) {
        LOG.info("Method in subtract");
        return num1 - num2;
    }

    @Override
    public double multiply(int num1, int num2) {
        LOG.info("Method in multiply");
        return num1 * num2;
    }

    @Override
    public double divide(int num1, int num2) {
        LOG.info("Method in divide");
        if (num2 == 0) {
            throw new ValidationException("Divisor should not be zero");
        }
        return (double) num1 / num2;
    }
}
