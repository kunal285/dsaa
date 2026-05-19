package com.events.manager.models;

public class Venue {
    private final String venueId;
    private final String venueName;
    private final int capacity;

    public Venue(String venueId, String venueName, int capacity) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.capacity = capacity;
    }

    public int getCapacity() { return capacity; }
    public String getVenueName() { return venueName; }
}
