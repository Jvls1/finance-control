package com.jojo.financialcontrol.infra.exception;

public class FinanceControlRuntimeException extends RuntimeException {

    public FinanceControlRuntimeException(String errorMessage) {
        super(errorMessage);
    }
}
