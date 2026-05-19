package com.hotel.booking;

/**
 * Custom checked exception for validation errors.
 */
public class HotelException extends Exception {
    public HotelException(final String message) {
        super(message);
    }
}