package com.fooddelivery.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for FoodOrder objects.
 */
public class DeliveryManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<FoodOrder> items = new ArrayList<>();

    public void add(final FoodOrder item) throws FoodDeliveryException {
        if (item == null) {
            throw new FoodDeliveryException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new FoodDeliveryException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<FoodOrder> getAll() {
        return Collections.unmodifiableList(items);
    }

    public FoodOrder findByName(final String name) {
        for (FoodOrder item : items) {
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

        for (FoodOrder item : items) {
            System.out.println(item);
        }
    }
}