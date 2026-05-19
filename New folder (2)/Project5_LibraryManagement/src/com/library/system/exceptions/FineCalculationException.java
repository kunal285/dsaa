package com.library.system.exceptions;

/**
 * Custom exception for fine calculation errors
 */
public class FineCalculationException extends Exception {
    public FineCalculationException(String message) {
        super(message);
    }

    public FineCalculationException(String message, Throwable cause) {
        super(message, cause);
    }
}
