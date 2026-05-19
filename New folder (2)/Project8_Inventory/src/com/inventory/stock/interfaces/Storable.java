package com.inventory.stock.interfaces;

import com.inventory.stock.exceptions.StockException;

public interface Storable {
    void addStock(int quantity) throws StockException;
    void removeStock(int quantity) throws StockException;
    int getStock();
    boolean isLowStock();
}
