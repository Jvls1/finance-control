package com.jojo.financialcontrol.exception;

public class AuthenticationNotFoundException extends RuntimeException {

    public AuthenticationNotFoundException() {
        super("No authentication");
    }
    public AuthenticationNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
