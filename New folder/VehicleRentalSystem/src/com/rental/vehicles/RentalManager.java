package com.rental.vehicles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for Vehicle objects.
 */
public class RentalManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<Vehicle> items = new ArrayList<>();

    public void add(final Vehicle item) throws RentalException {
        if (item == null) {
            throw new RentalException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new RentalException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<Vehicle> getAll() {
        return Collections.unmodifiableList(items);
    }

    public Vehicle findByName(final String name) {
        for (Vehicle item : items) {
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

        for (Vehicle item : items) {
            System.out.println(item);
        }
    }
}