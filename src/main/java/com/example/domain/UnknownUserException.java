package com.example.domain;

public class UnknownUserException extends Exception {
    public UnknownUserException(String name) {
        super(String.format("User %s not found", name));
    }
}
