package com.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) class representing an authentication request.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    /**
     * The username for authentication.
     */
    private String username;

    /**
     * The password for authentication.
     */
    private String password;

}
