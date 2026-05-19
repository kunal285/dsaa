package com.hospital.appointments.interfaces;

import com.hospital.appointments.exceptions.AppointmentException;

public interface Schedulable {
    void bookAppointment(String patientId, String timeSlot) throws AppointmentException;
    void cancelAppointment(String appointmentId) throws AppointmentException;
    boolean isSlotAvailable(String timeSlot);
}
