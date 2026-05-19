package com.hotel.booking;


/**
 * Concrete entity that stores the project-specific data.
 */
public class HotelBooking extends RoomRecord implements Bookable {
    private String roomType;
    private int nights;
    private double ratePerNight;


    public HotelBooking(final String name, final String roomType, final int nights, final double ratePerNight) throws HotelException {
        super(name);
        if (roomType == null || roomType.trim().isEmpty()) {             throw new HotelException("Room type cannot be blank.");         }         if (nights < 1) {             throw new HotelException("Nights must be at least 1.");         }         if (ratePerNight < 0.0) {             throw new HotelException("Rate per night cannot be negative.");         }
        this.roomType = roomType;
        this.nights = nights;
        this.ratePerNight = ratePerNight;

    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(final String roomType) throws HotelException {
        if (roomType == null || roomType.trim().isEmpty()) {
            throw new HotelException("Room type cannot be blank.");
        }
        this.roomType = roomType;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(final int nights) throws HotelException {
        if (nights < 1) {
            throw new HotelException("Nights must be at least 1.");
        }
        this.nights = nights;
    }

    public double getRatePerNight() {
        return ratePerNight;
    }

    public void setRatePerNight(final double ratePerNight) throws HotelException {
        if (ratePerNight < 0.0) {
            throw new HotelException("Rate per night cannot be negative.");
        }
        this.ratePerNight = ratePerNight;
    }

    @Override
    public boolean bookRoom() {
        return nights > 0;
    }

    @Override
    public double totalCost() {
        return nights * ratePerNight;
    }


    public String describe() {
        return getBasicInfo() + ", " + "roomType=" + roomType + ", " + "nights=" + nights + ", " + "ratePerNight=" + ratePerNight;
    }

    @Override
    public String toString() {
        return describe();
    }

    @Override
    public String getCategory() {
        return "HotelBooking";
    }
}