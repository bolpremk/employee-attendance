package com.domain.filter;

import com.domain.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * Gateway filter for authentication.
 */
@Slf4j
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    @Autowired
    private RouteValidator validator;
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * Constructs an AuthFilter instance.
     */
    public AuthFilter() {
        super(Config.class);
    }

    /**
     * Applies the filter to the given exchange.
     *
     * @param config  The filter configuration.
     * @return The gateway filter.
     */
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {

            // Validate user token
            validateUserToken(exchange);

            ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
            log.info("Reached GatewayFilter with" + exchange.getRequest().getPath().value());
            return chain.filter(exchange.mutate().request(builder.build()).build());
        };
    }

    /**
     * Validates the user token.
     *
     * @param exchange The server web exchange.
     */
    private void validateUserToken(ServerWebExchange exchange) {
        if (validator.isSecured.test(exchange.getRequest())) {
            if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                log.info("missing authorization header");
                throw new RuntimeException("missing authorization header");
            }

            String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                authHeader = authHeader.substring(7);
            }
            try {
                jwtUtil.validateToken(authHeader);
                log.info("JWT token validated");
            } catch (Exception e) {
                log.info("invalid access...!");
                throw new RuntimeException("unauthorized access to application");
            }
        }
    }

    /**
     * Configuration class for AuthFilter.
     */
    public static class Config {
    }
}
