package com.railway.reservation;

/**
 * Custom checked exception for validation errors.
 */
public class RailwayException extends Exception {
    public RailwayException(final String message) {
        super(message);
    }
}