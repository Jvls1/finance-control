package com.jojo.financialcontrol.exception;

public class UserCreationException extends RuntimeException {

    public UserCreationException(String errorMessage) {
        super(errorMessage);
    }
}
