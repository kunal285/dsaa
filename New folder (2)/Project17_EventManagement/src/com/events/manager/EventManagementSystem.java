package com.events.manager;

import com.events.manager.models.Event;
import com.events.manager.models.Venue;

import java.time.LocalDateTime;

public class EventManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Event Management System ===\n");
        Venue venue = new Venue("V001", "Convention Center", 500);
        Event event = new Event("Tech Conference 2024", LocalDateTime.now().plusDays(30), venue.getCapacity());
        
        System.out.println("✓ Event: " + event.getEventName());
        System.out.println("  Venue: " + venue.getVenueName());
        System.out.println("  Capacity: " + event.getAvailableSeats());
        
        event.registerAttendee();
        event.registerAttendee();
        System.out.println("\n✓ Registered 2 attendees");
        System.out.println("  Available Seats: " + event.getAvailableSeats());
    }
}
