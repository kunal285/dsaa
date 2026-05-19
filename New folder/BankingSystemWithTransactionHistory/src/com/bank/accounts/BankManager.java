package com.bank.accounts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for BankAccount objects.
 */
public class BankManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<BankAccount> items = new ArrayList<>();

    public void add(final BankAccount item) throws BankingException {
        if (item == null) {
            throw new BankingException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new BankingException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<BankAccount> getAll() {
        return Collections.unmodifiableList(items);
    }

    public BankAccount findByName(final String name) {
        for (BankAccount item : items) {
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

        for (BankAccount item : items) {
            System.out.println(item);
        }
    }
}