package com.hotel.booking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for HotelBooking objects.
 */
public class BookingManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<HotelBooking> items = new ArrayList<>();

    public void add(final HotelBooking item) throws HotelException {
        if (item == null) {
            throw new HotelException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new HotelException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<HotelBooking> getAll() {
        return Collections.unmodifiableList(items);
    }

    public HotelBooking findByName(final String name) {
        for (HotelBooking item : items) {
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

        for (HotelBooking item : items) {
            System.out.println(item);
        }
    }
}