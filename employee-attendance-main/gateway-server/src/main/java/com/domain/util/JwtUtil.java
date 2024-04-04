package com.domain.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

/**
 * Utility class for JWT (JSON Web Token) operations.
 */
@Component
public class JwtUtil {

    /**
     * Secret key used for JWT signing and verification.
     */
    public static final String SECRET = "5732486C49703373367639792F423F4528482B4D6251655468576D5B43132410";

    /**
     * Validates the provided JWT token.
     *
     * @param token The JWT token to validate.
     * @throws Exception If the token validation fails.
     */
    public void validateToken(final String token) throws Exception {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }

    /**
     * Retrieves the signing key for JWT operations.
     *
     * @return The signing key.
     */
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
