package com.smarthome.devices;

/**
 * Contract for Configurable behavior.
 */
public interface Configurable {
    void configureMode(final String mode);
    String currentConfiguration();
}