package com.inventory.stock;

/**
 * Contract for Storable behavior.
 */
public interface Storable {
    void addStock(final int quantity);
    void removeStock(final int quantity);
    String stockStatus();
}