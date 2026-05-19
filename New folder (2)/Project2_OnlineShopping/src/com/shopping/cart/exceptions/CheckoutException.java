package com.shopping.cart.exceptions;

/**
 * Custom exception for checkout operations
 */
public class CheckoutException extends Exception {
    public CheckoutException(String message) {
        super(message);
    }

    public CheckoutException(String message, Throwable cause) {
        super(message, cause);
    }
}
