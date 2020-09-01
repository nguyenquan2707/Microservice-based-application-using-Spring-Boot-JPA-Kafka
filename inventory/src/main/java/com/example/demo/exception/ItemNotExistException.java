package com.example.demo.exception;

public class ItemNotExistException extends RuntimeException {

    String message;

    public ItemNotExistException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}