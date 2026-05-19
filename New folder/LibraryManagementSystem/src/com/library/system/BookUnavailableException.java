package com.library.system;

/**
 * Thrown when a book cannot be issued because it is already borrowed.
 */
public class BookUnavailableException extends LibraryException {
    public BookUnavailableException(final String message) {
        super(message);
    }
}