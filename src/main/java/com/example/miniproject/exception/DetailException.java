package com.example.miniproject.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DetailException extends RuntimeException {

    private final transient ErrorData errorData;

    public DetailException(String message, String statusCode, LocalDateTime dateTime) {
        super(message);
        this.errorData = ErrorData.builder()
                .message(message)
                .dateTime(dateTime)
                .statusCode(statusCode)
                .build();
    }


}
