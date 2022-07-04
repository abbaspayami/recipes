package com.amro.recipes.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ExceptionDto {

    private String error;
    private int status;
    private String message;
    private LocalDateTime timestamp;

    /**
     * constructor
     *
     * @param message user custom message
     * @param status  relevant http status
     */
    public ExceptionDto(String message, HttpStatus status) {
        this.message = message;
        this.error = status.getReasonPhrase();
        this.status = status.value();
        this.timestamp = LocalDateTime.now();
    }

}
