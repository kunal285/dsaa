package com.railway.reservation.exceptions;

/**
 * Custom exception for cancellation errors
 */
public class CancellationException extends Exception {
    public CancellationException(String message) {
        super(message);
    }

    public CancellationException(String message, Throwable cause) {
        super(message, cause);
    }
}
