package com.example.kafkademo.exception;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Document(collection = "error_responses")
public class ErrorResponseDocument {

    @Id
    private String id;

    private String error;
    private String message;
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String details;
    private String path;
}

