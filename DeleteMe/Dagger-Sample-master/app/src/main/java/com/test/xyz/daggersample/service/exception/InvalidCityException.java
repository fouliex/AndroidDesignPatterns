package com.test.xyz.daggersample.service.exception;

public class InvalidCityException extends Exception {
    String message;

    public InvalidCityException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
