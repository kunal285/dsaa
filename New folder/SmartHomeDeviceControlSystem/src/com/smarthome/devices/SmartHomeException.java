package com.smarthome.devices;

/**
 * Custom checked exception for validation errors.
 */
public class SmartHomeException extends Exception {
    public SmartHomeException(final String message) {
        super(message);
    }
}