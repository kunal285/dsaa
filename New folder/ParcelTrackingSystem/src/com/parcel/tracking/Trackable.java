package com.parcel.tracking;

/**
 * Contract for Trackable behavior.
 */
public interface Trackable {
    String track();
    void updateStatus(final String status);
}