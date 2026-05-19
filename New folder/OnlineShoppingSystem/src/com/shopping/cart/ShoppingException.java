package com.shopping.cart;

/**
 * Custom checked exception for validation errors.
 */
public class ShoppingException extends Exception {
    public ShoppingException(final String message) {
        super(message);
    }
}