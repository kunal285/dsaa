package com.railway.reservation.exceptions;

/**
 * Custom exception for seat booking errors
 */
public class SeatBookingException extends Exception {
    public SeatBookingException(String message) {
        super(message);
    }

    public SeatBookingException(String message, Throwable cause) {
        super(message, cause);
    }
}
