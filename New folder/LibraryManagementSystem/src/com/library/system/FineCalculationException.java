package com.library.system;

/**
 * Thrown when a fine cannot be calculated due to invalid input.
 */
public class FineCalculationException extends LibraryException {
    public FineCalculationException(final String message) {
        super(message);
    }
}