package com.example.customer.exceptions;

public class NoCutomerExistException extends Exception {

    String message;

    public NoCutomerExistException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
