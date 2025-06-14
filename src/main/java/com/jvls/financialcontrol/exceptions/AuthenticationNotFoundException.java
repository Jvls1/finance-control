package com.jvls.financialcontrol.exceptions;

public class AuthenticationNotFoundException extends FinancialControlRuntimeException {

    public AuthenticationNotFoundException() {
        super("No authentication");
    }
    public AuthenticationNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
