package com.hotel.booking.models;

public final class Room {
    private final String roomId;
    private final String roomType;
    private final double pricePerNight;
    private boolean isAvailable;

    public Room(String roomId, String roomType, double pricePerNight) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
    }

    public void book() { this.isAvailable = false; }
    public void checkout() { this.isAvailable = true; }
    public boolean isAvailable() { return isAvailable; }
    public double getPricePerNight() { return pricePerNight; }
    public String getRoomId() { return roomId; }
}

public class Booking {
    private final String bookingId;
    private final String roomId;
    private final int nights;
    private final double totalCost;
    private static int bookingCounter = 0;

    public Booking(String roomId, int nights, double pricePerNight) {
        this.bookingId = "BK_" + (++bookingCounter);
        this.roomId = roomId;
        this.nights = nights;
        this.totalCost = nights * pricePerNight;
    }

    public String getBookingId() { return bookingId; }
    public double getTotalCost() { return totalCost; }
}
