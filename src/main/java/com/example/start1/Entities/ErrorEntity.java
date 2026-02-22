package com.example.start1.Entities;

import java.time.LocalDateTime;

public class ErrorEntity {
    private LocalDateTime localDateTime;
    private String message;

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorEntity(LocalDateTime localDateTime, String message) {
        this.localDateTime = localDateTime;
        this.message = message;
    }
}
