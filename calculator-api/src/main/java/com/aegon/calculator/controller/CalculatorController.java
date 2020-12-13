package com.aegon.calculator.controller;

import com.aegon.calculator.model.Result;
import com.aegon.calculator.service.CalculatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * The Calculator Controller Class
 *
 * @author ragesh
 */
@RestController
@Validated
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/calc")
@Slf4j
public class CalculatorController {

    /**
     * Instantiates calculatorservice
     */
    @Autowired
    private CalculatorService calculatorService;

    /**
     * Adding two numbers
     * @param num1 as int
     * @param num2 as int
     * @return result object
     */
    @Operation(description = "Add two numbers", summary = "Add two numbers (num1 and num2)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Could not add two numbers")
    })
    @GetMapping("/add/{num1}/{num2}")
    public ResponseEntity<Result> add(@PathVariable @Valid int num1, @PathVariable @Valid int num2) {
        return ResponseEntity.ok(new Result(calculatorService.add(num1, num2)));
    }

    /**
     * Subtract two numbers
     * @param num1 as int
     * @param num2 as int
     * @return result object
     */
    @Operation(description = "Subtract two numbers", summary = "Subtract two numbers (num1 and num2)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Could not subtract two numbers")
    })
    @GetMapping("/sub/{num1}/{num2}")
    public ResponseEntity<Result> subtract(@PathVariable int num1, @PathVariable int num2) {
        return ResponseEntity.ok(new Result(calculatorService.subtract(num1, num2)));
    }

    /**
     * Multiply two numbers
     * @param num1 as int
     * @param num2 as int
     * @return result object
     */
    @Operation(description = "Multiply two numbers", summary = "Multiply two numbers (num1 and num2)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Could not multiply two numbers")
    })
    @GetMapping("/multiply/{num1}/{num2}")
    public ResponseEntity<Result> multiply(@PathVariable int num1, @PathVariable int num2) {
        return ResponseEntity.ok(new Result(calculatorService.multiply(num1, num2)));
    }

    /**
     * Divide two numbers
     * @param num1 as int
     * @param num2 as int
     * @return result object
     */
    @Operation(description = "Divide two numbers", summary = "Divide two numbers (num1 and num2)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Could not divide two numbers")
    })
    @GetMapping("/divide/{num1}/{num2}")
    public ResponseEntity<Result> divide(@PathVariable int num1, @PathVariable int num2) {
        return ResponseEntity.ok(new Result(calculatorService.divide(num1, num2)));
    }
}
