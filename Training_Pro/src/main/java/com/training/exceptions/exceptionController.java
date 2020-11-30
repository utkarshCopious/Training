package com.training.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.management.RuntimeErrorException;

@ControllerAdvice
public class exceptionController {
    @ExceptionHandler(value = employeeNotFoundException.class)
    public ResponseEntity<Object> exception(employeeNotFoundException exception) {
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = processRuntimeErrorException.class)
    public ResponseEntity<Object> exception(processRuntimeErrorException exception) {
        return new ResponseEntity<>("Runtime error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = nothingToAddException.class)
    public ResponseEntity<Object> exception(nothingToAddException exception) {
        return new ResponseEntity<>("Empty dataset", HttpStatus.NO_CONTENT);
    }


}