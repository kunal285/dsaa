package com.events.manager.models;

import java.time.LocalDateTime;

public final class Event {
    private final String eventId;
    private final String eventName;
    private final LocalDateTime eventDate;
    private final int totalCapacity;
    private int registeredAttendees;
    private static int eventCounter = 0;

    public Event(String eventName, LocalDateTime eventDate, int totalCapacity) {
        this.eventId = "EVT_" + (++eventCounter);
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.totalCapacity = totalCapacity;
        this.registeredAttendees = 0;
    }

    public boolean registerAttendee() {
        if (registeredAttendees < totalCapacity) {
            registeredAttendees++;
            return true;
        }
        return false;
    }

    public int getAvailableSeats() { return totalCapacity - registeredAttendees; }
    public String getEventId() { return eventId; }
    public String getEventName() { return eventName; }
}

