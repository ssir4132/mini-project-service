package com.example.miniproject.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ErrorData {

    private String message;
    private String statusCode;
    private LocalDateTime dateTime;

    @Override
    public String toString() {
        return "ErrorDTO{" +
                "message='" + message + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
