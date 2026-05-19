package com.railway.reservation;


/**
 * Ticket that links a passenger to a train.
 */
public class Ticket extends TravelRecord implements Reservable {
    private final Train train;
    private final Passenger passenger;
    private int seatCount;
    private boolean confirmed;

    public Ticket(final String name, final Train train, final Passenger passenger, final int seatCount, final boolean confirmed) throws RailwayException {
        super(name);
        if (train == null) {
            throw new RailwayException("Train cannot be null.");
        }
        if (passenger == null) {
            throw new RailwayException("Passenger cannot be null.");
        }
        if (seatCount < 1) {
            throw new RailwayException("Seat count must be at least 1.");
        }

        this.train = train;
        this.passenger = passenger;
        this.seatCount = seatCount;
        this.confirmed = confirmed;
    }

    public Train getTrain() {
        return train;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public double calculateFare() {
        return seatCount * train.getFarePerSeat();
    }

    public void cancel() {
        confirmed = false;
    }

    @Override
    public boolean reserve() {
        if (confirmed) {
            return true;
        }

        if (train.isFull()) {
            return false;
        }
        try {
            train.bookSeats(seatCount);
            confirmed = true;
            return true;
        } catch (final RailwayException ex) {
            return false;
        }
    }

    @Override
    public String reservationDetails() {
        return confirmed ? "Reservation confirmed for " + passenger.getName() + " on train " + train.getTrainNumber() : "Reservation pending.";
    }

    @Override
    public String getCategory() {
        return "Ticket";
    }

    @Override
    public String describe() {
        return getBasicInfo() + ", train=" + train.getTrainNumber() + ", passenger=" + passenger.getName() + ", seatCount=" + seatCount + ", confirmed=" + confirmed;
    }

    @Override
    public String toString() {
        return describe();
    }
}