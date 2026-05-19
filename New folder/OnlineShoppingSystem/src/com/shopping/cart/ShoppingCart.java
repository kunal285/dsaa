package com.shopping.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for CartItem objects.
 */
public class ShoppingCart {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<CartItem> items = new ArrayList<>();

    public void add(final CartItem item) throws ShoppingException {
        if (item == null) {
            throw new ShoppingException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new ShoppingException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<CartItem> getAll() {
        return Collections.unmodifiableList(items);
    }

    public CartItem findByName(final String name) {
        for (CartItem item : items) {
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

        for (CartItem item : items) {
            System.out.println(item);
        }
    }
}