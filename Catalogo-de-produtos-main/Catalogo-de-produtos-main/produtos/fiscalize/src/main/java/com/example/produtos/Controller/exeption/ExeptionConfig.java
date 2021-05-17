package com.example.produtos.Controller.exeption;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExeptionConfig {
    @ExceptionHandler({
            EmptyResultDataAccessException.class
    })
    public ResponseEntity erroNotFound(Exception ex){
        return ResponseEntity.notFound().build();
    }

}
