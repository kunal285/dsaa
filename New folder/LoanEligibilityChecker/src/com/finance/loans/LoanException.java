package com.finance.loans;

/**
 * Custom checked exception for validation errors.
 */
public class LoanException extends Exception {
    public LoanException(final String message) {
        super(message);
    }
}