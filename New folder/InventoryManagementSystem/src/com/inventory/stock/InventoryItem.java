package com.inventory.stock;


/**
 * Concrete entity that stores the project-specific data.
 */
public class InventoryItem extends StockRecord implements Storable {
    private int quantity;
    private double unitPrice;
    private String stockCategory;


    public InventoryItem(final String name, final int quantity, final double unitPrice, final String stockCategory) throws InventoryException {
        super(name);
        if (quantity < 0) {             throw new InventoryException("Quantity cannot be negative.");         }         if (unitPrice < 0.0) {             throw new InventoryException("Unit price cannot be negative.");         }         if (stockCategory == null || stockCategory.trim().isEmpty()) {             throw new InventoryException("Category cannot be blank.");         }
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.stockCategory = stockCategory;

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) throws InventoryException {
        if (quantity < 0) {
            throw new InventoryException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(final double unitPrice) throws InventoryException {
        if (unitPrice < 0.0) {
            throw new InventoryException("Unit price cannot be negative.");
        }
        this.unitPrice = unitPrice;
    }

    public String getStockCategory() {
        return stockCategory;
    }

    public void setStockCategory(final String stockCategory) throws InventoryException {
        if (stockCategory == null || stockCategory.trim().isEmpty()) {
            throw new InventoryException("Category cannot be blank.");
        }
        this.stockCategory = stockCategory;
    }

    @Override
    public void addStock(final int quantity) {
        if (quantity <= 0) { throw new IllegalArgumentException("Quantity must be positive."); } this.quantity += quantity;
    }

    @Override
    public void removeStock(final int quantity) {
        if (quantity <= 0 || quantity > this.quantity) { throw new IllegalArgumentException("Invalid stock removal."); } this.quantity -= quantity;
    }

    @Override
    public String stockStatus() {
        return "Stock for " + getName() + ": " + quantity + " units";
    }


    @Override
    public String describe() {
        return getBasicInfo() + ", " + "quantity=" + quantity + ", " + "unitPrice=" + unitPrice + ", " + "stockCategory=" + stockCategory;
    }

    @Override
    public String toString() {
        return describe();
    }

    @Override
    public String getCategory() {
        return "InventoryItem";
    }
}