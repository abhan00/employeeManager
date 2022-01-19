package com.example.employeemanager.exception;

public class userNotFoundException extends RuntimeException {
    public userNotFoundException(String message) {
        super(message);
    }
}
