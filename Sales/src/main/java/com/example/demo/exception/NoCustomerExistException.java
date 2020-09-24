package com.example.demo.exception;

public class NoCustomerExistException extends RuntimeException {

    String message;

    public NoCustomerExistException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
