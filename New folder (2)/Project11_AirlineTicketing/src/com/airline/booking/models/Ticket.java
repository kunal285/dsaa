package com.airline.booking.models;

import java.time.LocalDateTime;

public final class Ticket {
    private final String ticketId;
    private final Passenger passenger;
    private final String flightNumber;
    private final String seatNumber;
    private final double fare;
    private final LocalDateTime bookingDate;
    private String status;

    public Ticket(String ticketId, Passenger passenger, String flightNumber, String seatNumber, double fare) {
        this.ticketId = ticketId;
        this.passenger = passenger;
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.fare = fare;
        this.bookingDate = LocalDateTime.now();
        this.status = "BOOKED";
    }

    public String getTicketId() { return ticketId; }
    public String getFlightNumber() { return flightNumber; }
    public double getFare() { return fare; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", passenger='" + passenger.getPassengerName() + '\'' +
                ", flight='" + flightNumber + '\'' +
                ", seat='" + seatNumber + '\'' +
                ", fare=" + fare +
                ", status='" + status + '\'' +
                '}';
    }
}
