package com.crud.comun.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<CustomError> handleNotFoundException(NotFoundException ex) {
        CustomError exceptionResponse = new CustomError(new Date(), 404, ex.getMessage());
        return new ResponseEntity<CustomError>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnprocesableException.class)
    public final ResponseEntity<CustomError> handleUnprocesableException(UnprocesableException ex) {
        CustomError exceptionResponse = new CustomError(new Date(), 422, ex.getMessage());
        return new ResponseEntity<CustomError>(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
