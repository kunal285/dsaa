package com.airline.booking;

import com.airline.booking.exceptions.FlightException;
import com.airline.booking.models.Flight;
import com.airline.booking.models.Passenger;
import com.airline.booking.models.Ticket;

public class AirlineTicketingSystem {
    public static void main(String[] args) {
        try {
            System.out.println("=== Airline Ticketing System ===\n");

            Flight flight1 = new Flight("FL001", "AI-101", "Mumbai", "Delhi", 180, 5000.0);
            Passenger p1 = new Passenger("PASS001", "Rahul Sharma", 35, "A12345678");
            Passenger p2 = new Passenger("PASS002", "Priya Singh", 28, "B87654321");

            System.out.println("--- Flight Info ---");
            System.out.println(flight1);

            String ticket1Id = flight1.bookSeat(p1);
            String ticket2Id = flight1.bookSeat(p2);

            System.out.println("\n--- Bookings ---");
            System.out.println("✓ Booked " + p1.getPassengerName() + " - Ticket: " + ticket1Id);
            System.out.println("✓ Booked " + p2.getPassengerName() + " - Ticket: " + ticket2Id);
            System.out.println("✓ Available Seats: " + flight1.getAvailableSeats());

            flight1.checkIn(ticket1Id);
            System.out.println("\n--- Check-in ---");
            System.out.println("✓ " + p1.getPassengerName() + " checked in");
            System.out.println("  Status: " + flight1.getCheckInStatus(ticket1Id));

            System.out.println("\n--- Testing Invalid Operations ---");
            try {
                Flight smallFlight = new Flight("FL002", "AI-102", "Chennai", "Bangalore", 0, 3000);
            } catch (FlightException e) {
                System.out.println("✓ Caught: " + e.getMessage());
            }

        } catch (FlightException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
