package com.jojo.financialcontrol.infra.exception;

public class UserCreationException extends FinanceControlException {

    public UserCreationException(String errorMessage) {
        super(errorMessage);
    }
}
