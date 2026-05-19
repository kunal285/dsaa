package com.airline.booking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for FlightBooking objects.
 */
public class AirlineManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<FlightBooking> items = new ArrayList<>();

    public void add(final FlightBooking item) throws AirlineException {
        if (item == null) {
            throw new AirlineException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new AirlineException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<FlightBooking> getAll() {
        return Collections.unmodifiableList(items);
    }

    public FlightBooking findByName(final String name) {
        for (FlightBooking item : items) {
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

        for (FlightBooking item : items) {
            System.out.println(item);
        }
    }
}