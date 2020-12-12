package com.aegon.calculator.service;

/**
 * The Calculator Service Interface
 *
 * @author ragesh
 */
public interface CalculatorService {
    /**
     * Add two numbers
     *
     * @param num1 as int
     * @param num2 as int
     * @return double
     */
    double add(int num1, int num2);

    /**
     * Subtract two numbers
     *
     * @param num1 as int
     * @param num2 as int
     * @return double
     */
    double subtract(int num1, int num2);

    /**
     * Multiply two numbers
     *
     * @param num1 as int
     * @param num2 as int
     * @return double
     */
    double multiply(int num1, int num2);

    /**
     * Divide two numbers
     *
     * @param num1 as int
     * @param num2 as int
     * @return double
     */
    double divide(int num1, int num2);
}
