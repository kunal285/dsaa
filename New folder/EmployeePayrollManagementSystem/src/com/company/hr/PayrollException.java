package com.company.hr;

/**
 * Custom checked exception for validation errors.
 */
public class PayrollException extends Exception {
    public PayrollException(final String message) {
        super(message);
    }
}