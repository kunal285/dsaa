package com.railway.reservation.exceptions;

/**
 * Custom exception for invalid passenger data
 */
public class InvalidPassengerException extends Exception {
    public InvalidPassengerException(String message) {
        super(message);
    }

    public InvalidPassengerException(String message, Throwable cause) {
        super(message, cause);
    }
}
