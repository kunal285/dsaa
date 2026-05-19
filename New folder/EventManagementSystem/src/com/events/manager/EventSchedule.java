package com.events.manager;


/**
 * Concrete entity that stores the project-specific data.
 */
public class EventSchedule extends EventRecord implements Schedulable {
    private String eventDate;
    private int capacity;
    private int attendees;


    public EventSchedule(final String name, final String eventDate, final int capacity, final int attendees) throws EventException {
        super(name);
        if (eventDate == null || eventDate.trim().isEmpty()) {             throw new EventException("Event date cannot be blank.");         }         if (capacity < 1) {             throw new EventException("Capacity must be at least 1.");         }         if (attendees < 0 || attendees > capacity) {             throw new EventException("Attendees must be between 0 and capacity.");         }
        this.eventDate = eventDate;
        this.capacity = capacity;
        this.attendees = attendees;

    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(final String eventDate) throws EventException {
        if (eventDate == null || eventDate.trim().isEmpty()) {
            throw new EventException("Event date cannot be blank.");
        }
        this.eventDate = eventDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(final int capacity) throws EventException {
        if (capacity < 1) {
            throw new EventException("Capacity must be at least 1.");
        }
        this.capacity = capacity;
    }

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(final int attendees) throws EventException {
        if (attendees < 0 || attendees > capacity) {
            throw new EventException("Attendees must be between 0 and capacity.");
        }
        this.attendees = attendees;
    }

    @Override
    public boolean scheduleEvent() {
        return attendees <= capacity;
    }

    @Override
    public String eventStatus() {
        return attendees <= capacity ? "Event scheduled for " + eventDate : "Capacity exceeded.";
    }


    public String describe() {
        return getBasicInfo() + ", " + "eventDate=" + eventDate + ", " + "capacity=" + capacity + ", " + "attendees=" + attendees;
    }

    @Override
    public String toString() {
        return describe();
    }

    @Override
    public String getCategory() {
        return "EventSchedule";
    }
}