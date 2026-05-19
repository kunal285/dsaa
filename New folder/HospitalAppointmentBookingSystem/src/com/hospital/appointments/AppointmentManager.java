package com.hospital.appointments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for Appointment objects.
 */
public class AppointmentManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<Appointment> items = new ArrayList<>();

    public void add(final Appointment item) throws AppointmentException {
        if (item == null) {
            throw new AppointmentException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new AppointmentException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<Appointment> getAll() {
        return Collections.unmodifiableList(items);
    }

    public Appointment findByName(final String name) {
        for (Appointment item : items) {
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

        for (Appointment item : items) {
            System.out.println(item);
        }
    }
}