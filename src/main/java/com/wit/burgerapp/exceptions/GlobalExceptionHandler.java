package com.wit.burgerapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> burgerErrorResponseEntity(BurgerException burgerException) {
        BurgerErrorResponse errorResponse = new BurgerErrorResponse(burgerException.getMessage());
        return new ResponseEntity<>(errorResponse, burgerException.getStatus());
    }
    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> burgerErrorResponseEntity(Exception exception) {
        BurgerErrorResponse errorResponse = new BurgerErrorResponse(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
