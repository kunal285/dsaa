package com.hospital.appointments;

/**
 * Custom checked exception for validation errors.
 */
public class AppointmentException extends Exception {
    public AppointmentException(final String message) {
        super(message);
    }
}