package com.example.demo.exception;

import com.example.demo.model.entity.Item;
import com.example.demo.model.entity.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(ItemNotExistException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Response<Item>> handleItemNotFoundException(ItemNotExistException ex) {

        Response response = new Response();
        response.setMessage(ex.toString());
        response.setSuccess(false);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InsufficientQuantityException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Response<Item>> handleInsufficientQuantityException(InsufficientQuantityException ex) {

        Response response = new Response();
        response.setMessage(ex.toString());
        response.setSuccess(false);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
