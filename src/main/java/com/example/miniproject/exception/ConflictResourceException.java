package com.example.miniproject.exception;

import java.time.LocalDateTime;

public class ConflictResourceException extends DetailException {
    
    public ConflictResourceException(String message) {
        super(message, "CONFLICT_RESOURCE_EXCEPTION", LocalDateTime.now());
    }
}
