package com.smarthome.devices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for SmartDevice objects.
 */
public class DeviceManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<SmartDevice> items = new ArrayList<>();

    public void add(final SmartDevice item) throws SmartHomeException {
        if (item == null) {
            throw new SmartHomeException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new SmartHomeException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<SmartDevice> getAll() {
        return Collections.unmodifiableList(items);
    }

    public SmartDevice findByName(final String name) {
        for (SmartDevice item : items) {
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

        for (SmartDevice item : items) {
            System.out.println(item);
        }
    }
}