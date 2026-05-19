package com.fooddelivery.app;

/**
 * Custom checked exception for validation errors.
 */
public class FoodDeliveryException extends Exception {
    public FoodDeliveryException(final String message) {
        super(message);
    }
}