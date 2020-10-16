package com.bridgelabz.GreetingApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GreetingExceptionController extends RuntimeException{
    @ExceptionHandler(value = GreetingMessageException.class)
    public ResponseEntity<Object> exception(GreetingMessageException e) {
        return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
    }
}
