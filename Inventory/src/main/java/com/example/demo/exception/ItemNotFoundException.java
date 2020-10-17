package com.example.demo.exception;

public class ItemNotFoundException extends RuntimeException {

    String message;

    public ItemNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}