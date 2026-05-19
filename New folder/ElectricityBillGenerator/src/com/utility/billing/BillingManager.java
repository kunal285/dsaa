package com.utility.billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for ElectricityBill objects.
 */
public class BillingManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<ElectricityBill> items = new ArrayList<>();

    public void add(final ElectricityBill item) throws BillingException {
        if (item == null) {
            throw new BillingException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new BillingException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<ElectricityBill> getAll() {
        return Collections.unmodifiableList(items);
    }

    public ElectricityBill findByName(final String name) {
        for (ElectricityBill item : items) {
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

        for (ElectricityBill item : items) {
            System.out.println(item);
        }
    }
}