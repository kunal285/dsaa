package com.parcel.tracking;

/**
 * Base class that provides id generation and common name handling.
 */
public abstract class ParcelRecord {
    private static int nextId = 1;

    private final int id;
    private String name;

    protected ParcelRecord(final String name) throws ParcelException {
        validateName(name);
        this.id = nextId++;
        this.name = name.trim();
    }

    private void validateName(final String value) throws ParcelException {
        if (value == null || value.trim().isEmpty()) {
            throw new ParcelException("Name cannot be blank.");
        }
    }

    public final int getId() {
        return id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) throws ParcelException {
        validateName(name);
        this.name = name.trim();
    }

    public abstract String getCategory();

    public String describe() {
        return getBasicInfo();
    }

    public String getBasicInfo() {
        return getCategory() + " [ID=" + id + ", Name=" + name + "]";
    }
}