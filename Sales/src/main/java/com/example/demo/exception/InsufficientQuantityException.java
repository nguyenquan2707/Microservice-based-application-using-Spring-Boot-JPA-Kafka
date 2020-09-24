package com.example.demo.exception;

public class InsufficientQuantityException  extends RuntimeException{

    String message;

    public InsufficientQuantityException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
