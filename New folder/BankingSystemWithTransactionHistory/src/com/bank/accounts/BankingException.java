package com.bank.accounts;

/**
 * Custom checked exception for validation errors.
 */
public class BankingException extends Exception {
    public BankingException(final String message) {
        super(message);
    }
}