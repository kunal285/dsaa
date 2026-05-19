package com.parcel.tracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for Parcel objects.
 */
public class TrackingManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<Parcel> items = new ArrayList<>();

    public void add(final Parcel item) throws ParcelException {
        if (item == null) {
            throw new ParcelException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new ParcelException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<Parcel> getAll() {
        return Collections.unmodifiableList(items);
    }

    public Parcel findByName(final String name) {
        for (Parcel item : items) {
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

        for (Parcel item : items) {
            System.out.println(item);
        }
    }
}