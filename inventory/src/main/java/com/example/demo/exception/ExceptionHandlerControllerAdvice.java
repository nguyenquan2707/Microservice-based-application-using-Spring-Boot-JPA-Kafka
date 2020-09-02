package com.example.demo.exception;

import com.example.demo.model.entity.Item;
import com.example.demo.model.entity.Response;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Response<Item>> handleValidation(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            FieldError fieldError = (FieldError) error;
            String fieldName = fieldError.getField();
            String errorMsg = fieldError.getDefaultMessage();
            errors.put(fieldName, errorMsg);
        });
        Response response = new Response();
        response.setMessage(ex.toString());
        response.setData(errors);
        response.setSuccess(false);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

  /* @Override
   protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                 HttpHeaders headers, HttpStatus status, WebRequest request) {
       Map<String, String> errors = new HashMap<>();
       ex.getBindingResult().getAllErrors().forEach((error) -> {
           FieldError fieldError = (FieldError) error;
           String fieldName = fieldError.getField();
           String errorMsg = fieldError.getDefaultMessage();
           errors.put(fieldName, errorMsg);
       });
       Response response = new Response();
       response.setMessage(ex.toString());
       response.setData(errors);
       response.setSuccess(false);

       return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
   }*/

}
