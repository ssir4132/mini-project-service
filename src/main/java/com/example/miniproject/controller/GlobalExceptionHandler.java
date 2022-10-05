package com.example.miniproject.controller;

import com.example.miniproject.exception.ConflictResourceException;
import com.example.miniproject.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleNotFound(ResourceNotFoundException ex, WebRequest request) {

        log.warn(ex.getMessage(), ex);

        return handleExceptionInternal(ex, ex.getErrorData(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);

    }

    @ExceptionHandler(value = {ConflictResourceException.class})
    public ResponseEntity<Object> handleConflictResource(ConflictResourceException ex, WebRequest request) {

        log.warn(ex.getMessage(), ex);

        return handleExceptionInternal(ex, ex.getErrorData(), new HttpHeaders(), HttpStatus.CONFLICT, request);

    }

}
