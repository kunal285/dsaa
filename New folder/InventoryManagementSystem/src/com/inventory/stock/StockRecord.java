package com.inventory.stock;

/**
 * Base class that provides id generation and common name handling.
 */
public abstract class StockRecord {
    private static int nextId = 1;

    private final int id;
    private String name;

    protected StockRecord(final String name) throws InventoryException {
        validateName(name);
        this.id = nextId++;
        this.name = name.trim();
    }

    private void validateName(final String value) throws InventoryException {
        if (value == null || value.trim().isEmpty()) {
            throw new InventoryException("Name cannot be blank.");
        }
    }

    public final int getId() {
        return id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) throws InventoryException {
        validateName(name);
        this.name = name.trim();
    }

    public abstract String getCategory();

    public String describe() {
        return getBasicInfo();
    }

    public String getBasicInfo() {
        return getCategory() + " [ID=" + id + ", Name=" + name + "]";
    }
}