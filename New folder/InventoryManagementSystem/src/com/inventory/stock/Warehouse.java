package com.inventory.stock;

/**
 * Represents a warehouse that holds an inventory.
 */
public class Warehouse extends StockRecord {
    private final String location;
    private final Inventory inventory = new Inventory();

    public Warehouse(final String name, final String location) throws InventoryException {
        super(name);
        if (location == null || location.trim().isEmpty()) {
            throw new InventoryException("Location cannot be blank.");
        }

        this.location = location.trim();
    }

    public String getLocation() {
        return location;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String reorderAlert(final Item item) {
        return item.needsReorder() ? "Reorder alert for " + item.getItemCode() : "Stock level is sufficient for " + item.getItemCode();
    }

    @Override
    public String getCategory() {
        return "Warehouse";
    }

    @Override
    public String describe() {
        return getBasicInfo() + ", location=" + location + ", totalItems=" + inventory.getItems().size();
    }

    @Override
    public String toString() {
        return describe();
    }
}