package com.domain.controller;

import com.domain.dto.AuthRequest;
import com.domain.entity.UserCredential;
import com.domain.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling authentication-related requests.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * Endpoint for registering a new user.
     *
     * @param user The user to register.
     * @return A message indicating the result of the registration process.
     */
    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user) {
        return service.saveUser(user);
    }

    /**
     * Endpoint for obtaining an authentication token.
     *
     * @param authRequest The authentication request containing username and password.
     * @return The authentication token.
     */
    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return service.generateToken(authRequest.getUsername());
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    /**
     * Endpoint for validating an authentication token.
     *
     * @param token The authentication token to validate.
     * @return A message indicating the validation result.
     */
    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }
}
