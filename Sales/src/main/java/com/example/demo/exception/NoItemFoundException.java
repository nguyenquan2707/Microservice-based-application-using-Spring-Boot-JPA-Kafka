package com.example.demo.exception;

public class NoItemFoundException extends RuntimeException{

    String message;

    public NoItemFoundException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
