package org.order.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.avaje.inject.Bean;
import io.avaje.inject.Factory;

@Factory
public class JacksonFactory {

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
