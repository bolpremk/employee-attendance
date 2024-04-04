package com.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the API Gateway application.
 */
@SpringBootApplication
public class ApiGateway {

    /**
     * Main method to start the API Gateway application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(ApiGateway.class, args);
    }
}
