package com.dlms.notificationservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        System.out.println("❌ ERROR in Notification-Service:");
        ex.printStackTrace(); // Print full error
        
        return ResponseEntity.status(500).body("Internal Server Error");
    }
}