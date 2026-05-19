package com.hotel.booking;

/**
 * Contract for Bookable behavior.
 */
public interface Bookable {
    boolean bookRoom();
    double totalCost();
}