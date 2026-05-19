package com.library.system;

/**
 * Custom checked exception for validation errors.
 */
public class LibraryException extends Exception {
    public LibraryException(final String message) {
        super(message);
    }
}