package com.quiz.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for QuizAttempt objects.
 */
public class QuizManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<QuizAttempt> items = new ArrayList<>();

    public void add(final QuizAttempt item) throws QuizException {
        if (item == null) {
            throw new QuizException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new QuizException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<QuizAttempt> getAll() {
        return Collections.unmodifiableList(items);
    }

    public QuizAttempt findByName(final String name) {
        for (QuizAttempt item : items) {
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

        for (QuizAttempt item : items) {
            System.out.println(item);
        }
    }
}