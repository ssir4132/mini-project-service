package com.example.miniproject.exception;

import java.time.LocalDateTime;

public class ResourceNotFoundException extends DetailException {

    public ResourceNotFoundException(String message) {
        super(message, "RESOURCE_NOT_FOUND", LocalDateTime.now());
    }
}
