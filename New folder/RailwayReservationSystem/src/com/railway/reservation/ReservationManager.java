package com.railway.reservation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for Ticket objects.
 */
public class ReservationManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<Ticket> items = new ArrayList<>();

    public void add(final Ticket item) throws RailwayException {
        if (item == null) {
            throw new RailwayException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new RailwayException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<Ticket> getAll() {
        return Collections.unmodifiableList(items);
    }

    public Ticket findByName(final String name) {
        for (Ticket item : items) {
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

        for (Ticket item : items) {
            System.out.println(item);
        }
    }
}