package com.library.system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for BookItem objects.
 */
public class LibraryManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<BookItem> items = new ArrayList<>();

    public void add(final BookItem item) throws LibraryException {
        if (item == null) {
            throw new LibraryException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new LibraryException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<BookItem> getAll() {
        return Collections.unmodifiableList(items);
    }

    public BookItem findByName(final String name) {
        for (BookItem item : items) {
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

        for (BookItem item : items) {
            System.out.println(item);
        }
    }
}