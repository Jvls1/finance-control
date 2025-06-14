package com.jojo.financialcontrol.exception;

public class ConflictException extends FinanceControlException {

    public ConflictException(String resourceName) {
        super("Conflict with resource: " + resourceName);
    }
}
