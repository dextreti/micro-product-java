package com.catalog.middleware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class GlobalExceptionListener {

    @Bean
    public DefaultErrorHandler errorHandler() {
        // Configura que si falla, espere 1 segundo y reintente (backoff)
        // Si quieres que no reintente, pon maxAttempts = 0
        return new DefaultErrorHandler((record, exception) -> {
            System.err.println("ERROR GLOBAL KAFKA: Error procesando el mensaje con offset "
                    + record.offset() + ". Causa: " + exception.getMessage());
        }, new FixedBackOff(1000L, 2));
    }
}
