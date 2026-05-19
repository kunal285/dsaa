package com.airline.booking.interfaces;

import com.airline.booking.exceptions.FlightException;

public interface CheckIn {
    void checkIn(String ticketId) throws FlightException;
    String getCheckInStatus(String ticketId);
}
