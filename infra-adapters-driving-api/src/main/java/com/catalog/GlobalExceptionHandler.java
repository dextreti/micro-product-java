package com.catalog;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnexpected(Exception ex) {
        // Log full stack trace
        ex.printStackTrace(); // or use proper logger
        return ResponseEntity.status(500).body("Internal error: " + ex.getMessage());
    }
}
