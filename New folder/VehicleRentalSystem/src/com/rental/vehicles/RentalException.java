package com.rental.vehicles;

/**
 * Custom checked exception for validation errors.
 */
public class RentalException extends Exception {
    public RentalException(final String message) {
        super(message);
    }
}