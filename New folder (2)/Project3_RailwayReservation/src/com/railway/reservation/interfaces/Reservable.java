package com.railway.reservation.interfaces;

import com.railway.reservation.exceptions.CancellationException;
import com.railway.reservation.exceptions.SeatBookingException;

/**
 * Interface for reservable items (Train/Seat)
 */
public interface Reservable {
    /**
     * Reserve a seat
     * @param seatNumber seat number to reserve
     * @return ticket ID
     * @throws SeatBookingException if booking fails
     */
    String reserveSeat(String seatNumber) throws SeatBookingException;

    /**
     * Cancel a reservation
     * @param ticketId ticket ID to cancel
     * @throws CancellationException if cancellation fails
     */
    void cancelReservation(String ticketId) throws CancellationException;

    /**
     * Check if seat is available
     * @param seatNumber seat number
     * @return true if available
     */
    boolean isSeatAvailable(String seatNumber);

    /**
     * Get available seats count
     * @return count of available seats
     */
    int getAvailableSeatsCount();
}
