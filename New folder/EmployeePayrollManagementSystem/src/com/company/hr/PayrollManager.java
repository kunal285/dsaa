package com.company.hr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for Employee objects.
 */
public class PayrollManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<Employee> items = new ArrayList<>();

    public void add(final Employee item) throws PayrollException {
        if (item == null) {
            throw new PayrollException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new PayrollException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<Employee> getAll() {
        return Collections.unmodifiableList(items);
    }

    public Employee findByName(final String name) {
        for (Employee item : items) {
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

        for (Employee item : items) {
            System.out.println(item);
        }
    }
}