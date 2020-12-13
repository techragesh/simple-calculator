package com.aegon.calculator.controller;

import com.aegon.calculator.exception.CalculatorServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * The Calculator Controller Advice Class
 *
 * @author ragesh
 */
@RestControllerAdvice(assignableTypes = {CalculatorController.class})
public class CalculatorControllerAdvice {

    /**
     * Handles any exception which relates technical
     *
     * @param ex CustomerServiceException
     * @return HTTP INTERNAL SERVER status
     */
    @ExceptionHandler(CalculatorServiceException.class)
    public ResponseEntity<ExceptionResponse> handleCustomerServiceException(CalculatorServiceException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex), INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles exception for the wrong input
     *
     * @param ex NumberFormatException
     * @return BAD_REQUEST status
     */
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ExceptionResponse> handleCustomerServiceException(NumberFormatException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex, "Input should be a number (no decimals)"), BAD_REQUEST);
    }

    /**
     * Handles exception for the valid division
     *
     * @param ex ValidationException
     * @return BAD_REQUEST status
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ExceptionResponse> handleCustomerServiceException(ValidationException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex), BAD_REQUEST);
    }

    /**
     * Handles the exception response message
     */
    public static class ExceptionResponse {
        /**
         * Holds the message
         */
        private final String message;

        public String getMessage() {
            return message;
        }

        /**
         * ExceptionResponse Constructor
         *
         * @param exception
         */
        public ExceptionResponse(Exception exception) {
            this.message = exception.getMessage();
        }

        /**
         * ExceptionResponse Constructor
         *
         * @param exception
         */
        public ExceptionResponse(Exception exception, String validationError) {
            this.message = "Error: " + validationError;
        }
    }
}
