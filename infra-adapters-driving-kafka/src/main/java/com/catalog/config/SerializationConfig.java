package com.catalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;

@Configuration
public class SerializationConfig {
    @Bean
    public RecordMessageConverter converter() {
        return new JsonMessageConverter(); // Esto habilita la conversión automática de JSON para TODOS los listeners
    }

}
