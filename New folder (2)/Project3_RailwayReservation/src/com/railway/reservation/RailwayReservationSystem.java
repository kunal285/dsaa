package com.railway.reservation;

import com.railway.reservation.exceptions.CancellationException;
import com.railway.reservation.exceptions.InvalidPassengerException;
import com.railway.reservation.exceptions.SeatBookingException;
import com.railway.reservation.models.Passenger;
import com.railway.reservation.models.Ticket;
import com.railway.reservation.models.Train;

/**
 * Main class for Railway Reservation System
 */
public class RailwayReservationSystem {
    public static void main(String[] args) {
        try {
            System.out.println("=== Railway Reservation System ===\n");

            // Create a train
            Train express = new Train("TR001", "Express 12345", "Mumbai", "Delhi", 60, 2500.0);

            System.out.println("--- Train Details ---");
            System.out.println(express);
            System.out.println("Available Seats: " + express.getAvailableSeatsCount());

            // Create passengers
            System.out.println("\n--- Creating Passengers ---");
            Passenger passenger1 = new Passenger("P001", "Rajesh Kumar", 35, "rajesh@email.com", "9876543210");
            Passenger passenger2 = new Passenger("P002", "Priya Singh", 28, "priya@email.com", "9123456789");
            Passenger passenger3 = new Passenger("P003", "Amit Patel", 42, "amit@email.com", "9988776655");

            System.out.println("✓ Passenger 1: " + passenger1.getPassengerName());
            System.out.println("✓ Passenger 2: " + passenger2.getPassengerName());
            System.out.println("✓ Passenger 3: " + passenger3.getPassengerName());

            // Book seats
            System.out.println("\n--- Booking Seats ---");
            Ticket ticket1 = express.bookSeat(passenger1, "S10");
            System.out.println("✓ " + ticket1);

            Ticket ticket2 = express.bookSeat(passenger2, "S11");
            System.out.println("✓ " + ticket2);

            Ticket ticket3 = express.bookSeat(passenger3, "S12");
            System.out.println("✓ " + ticket3);

            // Display train status after booking
            System.out.println("\n--- Train Status After Booking ---");
            System.out.println(express);
            System.out.println("Available Seats: " + express.getAvailableSeatsCount());

            // Try booking same seat again (should fail)
            System.out.println("\n--- Testing Duplicate Booking ---");
            testDuplicateBooking(express, passenger1);

            // Cancel a booking
            System.out.println("\n--- Cancelling Ticket ---");
            express.cancelReservation(ticket2.getTicketId());
            System.out.println("✓ Cancelled ticket: " + ticket2.getTicketId());
            System.out.println("Available Seats after cancellation: " + express.getAvailableSeatsCount());

            // Rebook the cancelled seat
            System.out.println("\n--- Rebooking Cancelled Seat ---");
            Passenger passenger4 = new Passenger("P004", "Neha Gupta", 31, "neha@email.com", "9555555555");
            Ticket ticket4 = express.bookSeat(passenger4, "S11");
            System.out.println("✓ " + ticket4);

            // Display final train status
            System.out.println("\n--- Final Train Status ---");
            System.out.println(express);
            System.out.println("Available Seats: " + express.getAvailableSeatsCount());
            System.out.println("Total Bookings: " + express.getBookings().size());

            // Test invalid inputs
            System.out.println("\n--- Testing Invalid Inputs ---");
            testInvalidPassenger();
            testInvalidSeat(express);
            testInvalidCancellation(express);

        } catch (InvalidPassengerException | SeatBookingException | CancellationException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void testDuplicateBooking(Train train, Passenger passenger) {
        try {
            System.out.println("Attempting to book already booked seat S10...");
            train.bookSeat(passenger, "S10");
        } catch (SeatBookingException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }

    private static void testInvalidPassenger() {
        try {
            System.out.println("Attempting to create passenger with invalid age...");
            new Passenger("P099", "Invalid", 200, "test@email.com", "9999999999");
        } catch (InvalidPassengerException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }

    private static void testInvalidSeat(Train train) {
        try {
            System.out.println("Attempting to book invalid seat...");
            Passenger passenger = new Passenger("P005", "Test", 25, "test@email.com", "9999999999");
            train.bookSeat(passenger, "S999");
        } catch (InvalidPassengerException | SeatBookingException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }

    private static void testInvalidCancellation(Train train) {
        try {
            System.out.println("Attempting to cancel non-existent ticket...");
            train.cancelReservation("INVALID_TICKET");
        } catch (CancellationException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }
}
