package com.aegon.calculator.exception;

/**
 * The Calculator Service CustomException Class
 *
 * @author ragesh
 */
public class CalculatorServiceException extends RuntimeException {

    /**
     * Instantiates a new CalculatorServiceException.
     */
    public CalculatorServiceException() {
        // Default Constructor
    }

    /**
     * Instantiates a new CalculatorServiceException.
     *
     * @param message - String
     */
    public CalculatorServiceException(String message) {
        super(message);
    }

    /**
     * Instantiates a new CalculatorServiceException.
     *
     * @param cause - Throwable
     */
    public CalculatorServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new CalculatorServiceException.
     *
     * @param message - String
     * @param cause - Throwable
     */
    public CalculatorServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}

