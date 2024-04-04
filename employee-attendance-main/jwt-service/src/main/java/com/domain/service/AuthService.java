package com.domain.service;

import com.domain.entity.UserCredential;
import com.domain.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service class for authentication-related operations.
 */
@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    /**
     * Saves a new user to the system.
     *
     * @param credential The user credential to save.
     * @return A message indicating the result of the operation.
     */
    public String saveUser(UserCredential credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        repository.save(credential);
        return "user added to the system";
    }

    /**
     * Generates a JWT (JSON Web Token) for the given username.
     *
     * @param username The username for which to generate the token.
     * @return The generated JWT.
     */
    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    /**
     * Validates the given JWT.
     *
     * @param token The JWT to validate.
     */
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
