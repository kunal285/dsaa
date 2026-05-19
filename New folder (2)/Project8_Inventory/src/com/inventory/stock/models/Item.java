package com.inventory.stock.models;

import com.inventory.stock.exceptions.StockException;
import com.inventory.stock.interfaces.Storable;

public final class Item implements Storable {
    private final String itemId;
    private final String itemName;
    private final double price;
    private int quantity;
    private final int reorderLevel;

    public Item(String itemId, String itemName, double price, int initialQuantity, int reorderLevel) 
            throws StockException {
        if (itemId == null || itemId.isEmpty()) {
            throw new StockException("Item ID cannot be empty");
        }
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = initialQuantity;
        this.reorderLevel = reorderLevel;
    }

    @Override
    public void addStock(int quantity) throws StockException {
        if (quantity < 0) {
            throw new StockException("Cannot add negative quantity");
        }
        this.quantity += quantity;
    }

    @Override
    public void removeStock(int quantity) throws StockException {
        if (quantity < 0) {
            throw new StockException("Cannot remove negative quantity");
        }
        if (quantity > this.quantity) {
            throw new StockException("Insufficient stock. Available: " + this.quantity + ", Requested: " + quantity);
        }
        this.quantity -= quantity;
    }

    @Override
    public int getStock() {
        return quantity;
    }

    @Override
    public boolean isLowStock() {
        return quantity <= reorderLevel;
    }

    public String getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getReorderLevel() { return reorderLevel; }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", reorderLevel=" + reorderLevel +
                ", isLowStock=" + isLowStock() +
                '}';
    }
}
