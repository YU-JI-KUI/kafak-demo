package com.example.kafkademo.aop;

import com.example.kafkademo.exception.ErrorResponse;
import com.example.kafkademo.exception.ErrorResponseDocument;
import com.example.kafkademo.mongo.repo.ErrorResponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired private ErrorResponseRepo errorResponseRepo;

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleServiceException(RuntimeException ex) {
        ErrorResponse errorResponse = new ErrorResponse();

        saveErrorResponseToMongoDB(errorResponse);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private void saveErrorResponseToMongoDB(ErrorResponse errorResponse) {
        ErrorResponseDocument document = new ErrorResponseDocument();
        document.setError(errorResponse.getError());
        document.setMessage(errorResponse.getMessage());
        document.setTimestamp(errorResponse.getTimestamp());
        document.setStatus(errorResponse.getStatus());
        document.setDetails(errorResponse.getDetails());
        document.setPath(errorResponse.getPath());

        errorResponseRepo.save(document);
    }
}