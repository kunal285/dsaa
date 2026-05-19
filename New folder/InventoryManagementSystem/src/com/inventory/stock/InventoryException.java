package com.inventory.stock;

/**
 * Custom checked exception for validation errors.
 */
public class InventoryException extends Exception {
    public InventoryException(final String message) {
        super(message);
    }
}