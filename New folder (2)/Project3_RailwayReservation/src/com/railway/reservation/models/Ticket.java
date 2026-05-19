package com.railway.reservation.models;

import java.time.LocalDateTime;

/**
 * Ticket class representing a railway ticket
 */
public final class Ticket {
    private final String ticketId;
    private final Passenger passenger;
    private final String trainName;
    private final String seatNumber;
    private final double fare;
    private final LocalDateTime bookingDate;
    private static int ticketCounter = 0;
    private static final String BOOKED = "BOOKED";
    private static final String CANCELLED = "CANCELLED";
    private String status;

    /**
     * Constructor for Ticket
     * @param passenger passenger details
     * @param trainName name of the train
     * @param seatNumber seat number
     * @param fare ticket fare
     */
    public Ticket(Passenger passenger, String trainName, String seatNumber, double fare) {
        this.ticketId = "TKT_" + (++ticketCounter);
        this.passenger = passenger;
        this.trainName = trainName;
        this.seatNumber = seatNumber;
        this.fare = fare;
        this.bookingDate = LocalDateTime.now();
        this.status = BOOKED;
    }

    /**
     * Cancel the ticket
     */
    public void cancel() {
        this.status = CANCELLED;
    }

    // Getters
    public String getTicketId() {
        return ticketId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public double getFare() {
        return fare;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", passengerName='" + passenger.getPassengerName() + '\'' +
                ", trainName='" + trainName + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", fare=" + fare +
                ", status='" + status + '\'' +
                '}';
    }
}
