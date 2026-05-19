package com.inventory.stock;

/**
 * Represents a stock item with a unique item code.
 */
public class Item extends StockRecord implements Storable {
    private final String itemCode;
    private int quantity;
    private double unitPrice;
    private final int reorderLevel;

    public Item(final String name, final String itemCode, final int quantity, final double unitPrice, final int reorderLevel) throws InventoryException {
        super(name);
        if (itemCode == null || itemCode.trim().isEmpty()) {
            throw new InventoryException("Item code cannot be blank.");
        }
        if (quantity < 0) {
            throw new InventoryException("Quantity cannot be negative.");
        }
        if (unitPrice < 0.0) {
            throw new InventoryException("Unit price cannot be negative.");
        }
        if (reorderLevel < 0) {
            throw new InventoryException("Reorder level cannot be negative.");
        }

        this.itemCode = itemCode.trim();
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.reorderLevel = reorderLevel;
    }

    public String getItemCode() {
        return itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public boolean needsReorder() {
        return quantity <= reorderLevel;
    }

    @Override
    public void addStock(final int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }

        this.quantity += quantity;
    }

    @Override
    public void removeStock(final int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        if (quantity > this.quantity) {
            throw new IllegalArgumentException("Stock underflow.");
        }

        this.quantity -= quantity;
    }

    @Override
    public String stockStatus() {
        return "Item " + itemCode + ": " + quantity + " units";
    }

    @Override
    public String getCategory() {
        return "Item";
    }

    @Override
    public String describe() {
        return getBasicInfo() + ", itemCode=" + itemCode + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", reorderLevel=" + reorderLevel;
    }

    @Override
    public String toString() {
        return describe();
    }
}