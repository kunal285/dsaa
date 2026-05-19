package com.shopping.cart.exceptions;

/**
 * Custom exception for invalid price operations
 */
public class InvalidPriceException extends Exception {
    public InvalidPriceException(String message) {
        super(message);
    }

    public InvalidPriceException(String message, Throwable cause) {
        super(message, cause);
    }
}
