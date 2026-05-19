package com.railway.reservation;

/**
 * Contract for Reservable behavior.
 */
public interface Reservable {
    boolean reserve();
    String reservationDetails();
}