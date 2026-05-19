package com.company.hr.exceptions;

/**
 * Custom exception for invalid working days
 */
public class InvalidWorkingDaysException extends Exception {
    public InvalidWorkingDaysException(String message) {
        super(message);
    }

    public InvalidWorkingDaysException(String message, Throwable cause) {
        super(message, cause);
    }
}
