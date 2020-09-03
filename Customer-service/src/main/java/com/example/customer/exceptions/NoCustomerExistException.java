package com.example.customer.exceptions;

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
