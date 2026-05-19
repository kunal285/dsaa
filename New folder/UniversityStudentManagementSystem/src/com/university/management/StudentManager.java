package com.university.management;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for Student objects.
 */
public class StudentManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<Student> items = new ArrayList<>();

    public void add(final Student item) throws UniversityException {
        if (item == null) {
            throw new UniversityException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new UniversityException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<Student> getAll() {
        return Collections.unmodifiableList(items);
    }

    public Student findByName(final String name) {
        for (Student item : items) {
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

        for (Student item : items) {
            System.out.println(item);
        }
    }
}