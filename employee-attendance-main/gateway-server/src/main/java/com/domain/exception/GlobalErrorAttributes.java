package com.domain.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

/**
 * Custom error attributes class to handle global error responses.
 */
@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {

    /**
     * Retrieves error attributes for a given server request.
     *
     * @param request The server request.
     * @param options The options for error attributes.
     * @return A map of error attributes.
     */
    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(request, options);
        Throwable error = this.getError(request);

        // Remove unnecessary error attributes
        map.remove("path");
        map.remove("error");
        map.remove("requestId");

        // Customize error status for specific error messages
        if ("missing authorization header".contains(error.getMessage())) {
            map.put("status", HttpStatus.UNAUTHORIZED.value());
        }

        // Set error message
        map.put("error", error.getMessage());
        return map;
    }
}
