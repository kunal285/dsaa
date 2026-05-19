package com.feedback.system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for CustomerFeedback objects.
 */
public class FeedbackManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<CustomerFeedback> items = new ArrayList<>();

    public void add(final CustomerFeedback item) throws FeedbackException {
        if (item == null) {
            throw new FeedbackException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new FeedbackException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<CustomerFeedback> getAll() {
        return Collections.unmodifiableList(items);
    }

    public CustomerFeedback findByName(final String name) {
        for (CustomerFeedback item : items) {
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

        for (CustomerFeedback item : items) {
            System.out.println(item);
        }
    }
}