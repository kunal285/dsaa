package com.finance.loans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for LoanApplication objects.
 */
public class LoanManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<LoanApplication> items = new ArrayList<>();

    public void add(final LoanApplication item) throws LoanException {
        if (item == null) {
            throw new LoanException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new LoanException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<LoanApplication> getAll() {
        return Collections.unmodifiableList(items);
    }

    public LoanApplication findByName(final String name) {
        for (LoanApplication item : items) {
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

        for (LoanApplication item : items) {
            System.out.println(item);
        }
    }
}