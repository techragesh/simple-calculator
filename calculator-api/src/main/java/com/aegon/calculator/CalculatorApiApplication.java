package com.aegon.calculator;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class.
 *
 * @author ragesh
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Calculator API", version = "1.0", description = "Calculator Service"))
public class CalculatorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApiApplication.class, args);
	}

}
