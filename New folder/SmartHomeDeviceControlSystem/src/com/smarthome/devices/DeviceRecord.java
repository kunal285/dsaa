package com.smarthome.devices;

/**
 * Base class that provides id generation and common name handling.
 */
public abstract class DeviceRecord {
    private static int nextId = 1;

    private final int id;
    private String name;

    protected DeviceRecord(final String name) throws SmartHomeException {
        validateName(name);
        this.id = nextId++;
        this.name = name.trim();
    }

    private void validateName(final String value) throws SmartHomeException {
        if (value == null || value.trim().isEmpty()) {
            throw new SmartHomeException("Name cannot be blank.");
        }
    }

    public final int getId() {
        return id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) throws SmartHomeException {
        validateName(name);
        this.name = name.trim();
    }

    public abstract String getCategory();

    public String getBasicInfo() {
        return getCategory() + " [ID=" + id + ", Name=" + name + "]";
    }
}