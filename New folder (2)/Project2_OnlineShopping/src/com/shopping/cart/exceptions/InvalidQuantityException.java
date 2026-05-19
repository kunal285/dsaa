package com.shopping.cart.exceptions;

/**
 * Custom exception for invalid quantity operations
 */
public class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }

    public InvalidQuantityException(String message, Throwable cause) {
        super(message, cause);
    }
}
