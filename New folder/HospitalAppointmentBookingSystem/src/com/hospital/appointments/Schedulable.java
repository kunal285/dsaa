package com.hospital.appointments;

/**
 * Contract for Schedulable behavior.
 */
public interface Schedulable {
    boolean scheduleAppointment();
    String appointmentSummary();
}