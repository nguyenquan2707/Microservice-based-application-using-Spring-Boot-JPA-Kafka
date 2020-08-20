package com.example.demo.exception;

public class ItemNotExistException extends Exception {

    String message;

    public ItemNotExistException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}