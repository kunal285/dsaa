package com.events.manager;

/**
 * Custom checked exception for validation errors.
 */
public class EventException extends Exception {
    public EventException(final String message) {
        super(message);
    }
}