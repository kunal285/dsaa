package com.inventory.stock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for InventoryItem objects.
 */
public class InventoryManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<InventoryItem> items = new ArrayList<>();

    public void add(final InventoryItem item) throws InventoryException {
        if (item == null) {
            throw new InventoryException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new InventoryException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<InventoryItem> getAll() {
        return Collections.unmodifiableList(items);
    }

    public InventoryItem findByName(final String name) {
        for (InventoryItem item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }

        return null;
    }

    public void printAll() {
        if (items.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        for (InventoryItem item : items) {
            System.out.println(item);
        }
    }
}