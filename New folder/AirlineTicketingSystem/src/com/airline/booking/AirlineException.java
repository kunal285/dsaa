package com.airline.booking;

/**
 * Custom checked exception for validation errors.
 */
public class AirlineException extends Exception {
    public AirlineException(final String message) {
        super(message);
    }
}