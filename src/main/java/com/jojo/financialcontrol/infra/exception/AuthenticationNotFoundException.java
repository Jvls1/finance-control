package com.jojo.financialcontrol.infra.exception;

public class AuthenticationNotFoundException extends FinanceControlRuntimeException {

    public AuthenticationNotFoundException() {
        super("No authentication");
    }
    public AuthenticationNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
