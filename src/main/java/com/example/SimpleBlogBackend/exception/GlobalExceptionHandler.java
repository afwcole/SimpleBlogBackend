package com.example.SimpleBlogBackend.exception;

import com.example.SimpleBlogBackend.controller.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({PostNotFoundException.class})
    public ResponseEntity<ErrorResponse> notFoundExceptionHandler(Exception generalException, WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse(generalException.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
