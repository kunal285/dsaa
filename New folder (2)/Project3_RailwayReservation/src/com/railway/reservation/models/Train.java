package com.railway.reservation.models;

import com.railway.reservation.exceptions.CancellationException;
import com.railway.reservation.exceptions.SeatBookingException;
import com.railway.reservation.interfaces.Reservable;

import java.util.HashMap;
import java.util.Map;

/**
 * Train class implementing railway train with seat reservation
 */
public final class Train implements Reservable {
    private final String trainId;
    private final String trainName;
    private final String source;
    private final String destination;
    private final int totalSeats;
    private final double farePerSeat;
    private final Map<String, Boolean> seatAvailability;
    private final Map<String, Ticket> bookings;

    /**
     * Constructor for Train
     * @param trainId unique train identifier
     * @param trainName name of the train
     * @param source source station
     * @param destination destination station
     * @param totalSeats total seats in train
     * @param farePerSeat fare per seat
     */
    public Train(String trainId, String trainName, String source, String destination, int totalSeats, double farePerSeat) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.farePerSeat = farePerSeat;
        this.seatAvailability = new HashMap<>();
        this.bookings = new HashMap<>();
        initializeSeats();
    }

    /**
     * Initialize all seats as available
     */
    private void initializeSeats() {
        for (int i = 1; i <= totalSeats; i++) {
            seatAvailability.put("S" + i, true);
        }
    }

    @Override
    public String reserveSeat(String seatNumber) throws SeatBookingException {
        if (!seatAvailability.containsKey(seatNumber)) {
            throw new SeatBookingException("Invalid seat number: " + seatNumber);
        }
        if (!seatAvailability.get(seatNumber)) {
            throw new SeatBookingException("Seat " + seatNumber + " is already booked");
        }
        seatAvailability.put(seatNumber, false);
        return "Reserved";
    }

    /**
     * Book a seat for a passenger
     * @param passenger passenger details
     * @param seatNumber seat number
     * @return ticket object
     * @throws SeatBookingException if booking fails
     */
    public Ticket bookSeat(Passenger passenger, String seatNumber) throws SeatBookingException {
        reserveSeat(seatNumber);
        Ticket ticket = new Ticket(passenger, this.trainName, seatNumber, farePerSeat);
        bookings.put(ticket.getTicketId(), ticket);
        return ticket;
    }

    @Override
    public void cancelReservation(String ticketId) throws CancellationException {
        if (!bookings.containsKey(ticketId)) {
            throw new CancellationException("Invalid ticket ID: " + ticketId);
        }
        Ticket ticket = bookings.get(ticketId);
        if (ticket.getStatus().equals("CANCELLED")) {
            throw new CancellationException("Ticket " + ticketId + " is already cancelled");
        }
        seatAvailability.put(ticket.getSeatNumber(), true);
        ticket.cancel();
    }

    @Override
    public boolean isSeatAvailable(String seatNumber) {
        return seatAvailability.getOrDefault(seatNumber, false);
    }

    @Override
    public int getAvailableSeatsCount() {
        return (int) seatAvailability.values().stream()
                .filter(available -> available)
                .count();
    }

    // Getters
    public String getTrainId() {
        return trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public double getFarePerSeat() {
        return farePerSeat;
    }

    public Map<String, Ticket> getBookings() {
        return new HashMap<>(bookings);
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainId='" + trainId + '\'' +
                ", trainName='" + trainName + '\'' +
                ", route='" + source + " -> " + destination + '\'' +
                ", totalSeats=" + totalSeats +
                ", availableSeats=" + getAvailableSeatsCount() +
                ", farePerSeat=" + farePerSeat +
                '}';
    }
}
