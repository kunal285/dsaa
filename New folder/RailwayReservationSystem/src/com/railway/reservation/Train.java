package com.railway.reservation;

/**
 * Represents a train with a limited number of seats.
 */
public class Train extends TravelRecord {
    private final String trainNumber;
    private final int totalSeats;
    private int bookedSeats;
    private final double farePerSeat;

    public Train(final String name, final String trainNumber, final int totalSeats, final double farePerSeat) throws RailwayException {
        super(name);
        if (trainNumber == null || trainNumber.trim().isEmpty()) {
            throw new RailwayException("Train number cannot be blank.");
        }
        if (totalSeats < 1) {
            throw new RailwayException("Total seats must be at least 1.");
        }
        if (farePerSeat < 0.0) {
            throw new RailwayException("Fare cannot be negative.");
        }

        this.trainNumber = trainNumber.trim();
        this.totalSeats = totalSeats;
        this.farePerSeat = farePerSeat;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public double getFarePerSeat() {
        return farePerSeat;
    }

    public int getAvailableSeats() {
        return totalSeats - bookedSeats;
    }

    public boolean isFull() {
        return getAvailableSeats() <= 0;
    }

    public void bookSeats(final int seats) throws RailwayException {
        if (seats < 1) {
            throw new RailwayException("Seat count must be at least 1.");
        }
        if (seats > getAvailableSeats()) {
            throw new RailwayException("Not enough seats available.");
        }

        bookedSeats += seats;
    }

    public void cancelSeats(final int seats) throws RailwayException {
        if (seats < 1 || seats > bookedSeats) {
            throw new RailwayException("Invalid cancellation count.");
        }

        bookedSeats -= seats;
    }

    @Override
    public String getCategory() {
        return "Train";
    }

    @Override
    public String describe() {
        return getBasicInfo() + ", trainNumber=" + trainNumber + ", totalSeats=" + totalSeats + ", bookedSeats=" + bookedSeats + ", farePerSeat=" + farePerSeat;
    }

    @Override
    public String toString() {
        return describe();
    }
}