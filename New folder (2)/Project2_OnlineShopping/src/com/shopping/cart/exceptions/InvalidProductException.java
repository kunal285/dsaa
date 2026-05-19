package com.shopping.cart.exceptions;

/**
 * Custom exception for invalid product data
 */
public class InvalidProductException extends Exception {
    public InvalidProductException(String message) {
        super(message);
    }

    public InvalidProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
