package com.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class to start the JWT application.
 */
@SpringBootApplication
public class JWTApplication {

    /**
     * Main method to start the application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(JWTApplication.class, args);
    }
}
