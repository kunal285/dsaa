package com.parcel.tracking;

/**
 * Custom checked exception for validation errors.
 */
public class ParcelException extends Exception {
    public ParcelException(final String message) {
        super(message);
    }
}