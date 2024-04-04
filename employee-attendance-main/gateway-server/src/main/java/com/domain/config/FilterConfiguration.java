package com.domain.config;

import com.domain.filter.AuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for defining filters.
 */
@Configuration
public class FilterConfiguration {

    /**
     * Defines and returns the AuthFilter bean.
     *
     * @return The AuthFilter bean instance.
     */
    @Bean
    AuthFilter authFilter() {

        return new AuthFilter();
    }
}
