package com.jvls.financialcontrol.exceptions;

public class ConflictException extends FinancialControlException {

    public ConflictException(String resourceName) {
        super("Conflict with resource: " + resourceName);
    }
}
