package com.example.demo.exception;

public class OrderNotFoundExcedption extends RuntimeException{


    String message;

    public OrderNotFoundExcedption(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
