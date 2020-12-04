package com.training.exceptions.controller;

import com.training.exceptions.exceptions.EmployeeNotFoundException;
import com.training.exceptions.exceptions.NothingToAddException;
import com.training.exceptions.exceptions.ProcessRuntimeErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Utkarsh Awasthi
 **/

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<Object> exception(EmployeeNotFoundException exception) {
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ProcessRuntimeErrorException.class)
    public ResponseEntity<Object> exception(ProcessRuntimeErrorException exception) {
        return new ResponseEntity<>("Runtime error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = NothingToAddException.class)
    public ResponseEntity<Object> exception(NothingToAddException exception) {
        return new ResponseEntity<>("Empty dataset", HttpStatus.NO_CONTENT);
    }


}