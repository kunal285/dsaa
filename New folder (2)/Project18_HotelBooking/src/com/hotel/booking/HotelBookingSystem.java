package com.hotel.booking;

import com.hotel.booking.models.Booking;
import com.hotel.booking.models.Room;

public class HotelBookingSystem {
    public static void main(String[] args) {
        System.out.println("=== Hotel Room Booking System ===\n");
        Room room = new Room("R101", "Deluxe", 3000.0);
        System.out.println("✓ Room " + room.getRoomId() + " (" + room.getRoomType() + ")");
        System.out.println("  Price per night: Rs. " + room.getPricePerNight());
        
        if (room.isAvailable()) {
            Booking booking = new Booking(room.getRoomId(), 3, room.getPricePerNight());
            room.book();
            System.out.println("\n✓ Booked Room for 3 nights");
            System.out.println("  Booking ID: " + booking.getBookingId());
            System.out.println("  Total Cost: Rs. " + booking.getTotalCost());
            System.out.println("  Room Status: " + (room.isAvailable() ? "Available" : "Booked"));
        }
    }
}
