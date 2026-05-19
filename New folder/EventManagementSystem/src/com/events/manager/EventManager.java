package com.events.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for EventSchedule objects.
 */
public class EventManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<EventSchedule> items = new ArrayList<>();

    public void add(final EventSchedule item) throws EventException {
        if (item == null) {
            throw new EventException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new EventException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<EventSchedule> getAll() {
        return Collections.unmodifiableList(items);
    }

    public EventSchedule findByName(final String name) {
        for (EventSchedule item : items) {
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

        for (EventSchedule item : items) {
            System.out.println(item);
        }
    }
}