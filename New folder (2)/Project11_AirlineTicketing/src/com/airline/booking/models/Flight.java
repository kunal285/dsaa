package com.airline.booking.models;

import com.airline.booking.exceptions.FlightException;
import com.airline.booking.interfaces.CheckIn;

import java.util.HashMap;
import java.util.Map;

public final class Flight implements CheckIn {
    private final String flightId;
    private final String flightNumber;
    private final String source;
    private final String destination;
    private final int totalSeats;
    private int availableSeats;
    private final double baseFare;
    private final Map<String, String> seatAssignments;
    private final Map<String, Boolean> checkedIn;
    private static int ticketCounter = 0;

    public Flight(String flightId, String flightNumber, String source, String destination,
                 int totalSeats, double baseFare) throws FlightException {
        if (totalSeats <= 0) {
            throw new FlightException("Total seats must be positive");
        }
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.baseFare = baseFare;
        this.seatAssignments = new HashMap<>();
        this.checkedIn = new HashMap<>();
    }

    public String bookSeat(Passenger passenger) throws FlightException {
        if (availableSeats <= 0) {
            throw new FlightException("No seats available");
        }
        String ticketId = "TKT_" + (++ticketCounter);
        String seatNumber = "SEAT_" + (totalSeats - availableSeats + 1);
        seatAssignments.put(ticketId, seatNumber);
        checkedIn.put(ticketId, false);
        availableSeats--;
        return ticketId;
    }

    @Override
    public void checkIn(String ticketId) throws FlightException {
        if (!seatAssignments.containsKey(ticketId)) {
            throw new FlightException("Invalid ticket ID");
        }
        checkedIn.put(ticketId, true);
    }

    @Override
    public String getCheckInStatus(String ticketId) {
        return checkedIn.getOrDefault(ticketId, false) ? "CHECKED_IN" : "NOT_CHECKED_IN";
    }

    public int getAvailableSeats() { return availableSeats; }
    public String getFlightId() { return flightId; }
    public String getFlightNumber() { return flightNumber; }
    public double getBaseFare() { return baseFare; }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", route='" + source + "-" + destination + '\'' +
                ", availableSeats=" + availableSeats + "/" + totalSeats +
                '}';
    }
}
