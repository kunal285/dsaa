package com.inventory.stock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed inventory with duplicate code checks.
 */
public class Inventory {
    private final ArrayList<Item> items = new ArrayList<>();

    public void addItem(final Item item) throws InventoryException {
        if (item == null) {
            throw new InventoryException("Item cannot be null.");
        }

        for (Item existing : items) {
            if (existing.getItemCode().equalsIgnoreCase(item.getItemCode())) {
                throw new InventoryException("Duplicate item code.");
            }
        }

        items.add(item);
    }

    public Item findByCode(final String itemCode) {
        for (Item item : items) {
            if (item.getItemCode().equalsIgnoreCase(itemCode)) {
                return item;
            }
        }

        return null;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void printAll() {
        if (items.isEmpty()) {
            System.out.println("No items available.");
            return;
        }

        for (Item item : items) {
            System.out.println(item);
        }
    }
}