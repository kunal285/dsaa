package com.utility.billing;

/**
 * Custom checked exception for validation errors.
 */
public class BillingException extends Exception {
    public BillingException(final String message) {
        super(message);
    }
}