package com.rental.store.advice;

import com.rental.store.dto.RestError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({NoSuchElementException.class})
    @ResponseBody
    protected Object handleNoSuchElementException(NoSuchElementException ex) {
        return new RestError(ex.getMessage());
    }
}
