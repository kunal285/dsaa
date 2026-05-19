package com.university.management;

/**
 * Custom checked exception for validation errors.
 */
public class UniversityException extends Exception {
    public UniversityException(final String message) {
        super(message);
    }
}