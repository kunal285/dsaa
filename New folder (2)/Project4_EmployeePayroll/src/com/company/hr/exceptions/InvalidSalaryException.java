package com.company.hr.exceptions;

/**
 * Custom exception for invalid salary operations
 */
public class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }

    public InvalidSalaryException(String message, Throwable cause) {
        super(message, cause);
    }
}
