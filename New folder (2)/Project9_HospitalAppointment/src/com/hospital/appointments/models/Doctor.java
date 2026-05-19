package com.hospital.appointments.models;

import com.hospital.appointments.exceptions.AppointmentException;
import com.hospital.appointments.interfaces.Schedulable;

import java.util.HashMap;
import java.util.Map;

public final class Doctor implements Schedulable {
    private final String doctorId;
    private final String doctorName;
    private final String specialization;
    private final String[] availableSlots;
    private final Map<String, Appointment> appointments;
    private static int appointmentCounter = 0;

    public Doctor(String doctorId, String doctorName, String specialization) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.availableSlots = new String[]{"09:00", "09:30", "10:00", "10:30", "14:00", "14:30", "15:00"};
        this.appointments = new HashMap<>();
    }

    @Override
    public void bookAppointment(String patientId, String timeSlot) throws AppointmentException {
        if (!isSlotAvailable(timeSlot)) {
            throw new AppointmentException("Slot " + timeSlot + " is not available");
        }
        
        String appointmentId = "APT_" + (++appointmentCounter);
        appointments.put(timeSlot, new Appointment(appointmentId, patientId, this.doctorId, timeSlot));
    }

    @Override
    public void cancelAppointment(String appointmentId) throws AppointmentException {
        for (Appointment apt : appointments.values()) {
            if (apt.getAppointmentId().equals(appointmentId)) {
                appointments.remove(apt.getTimeSlot());
                return;
            }
        }
        throw new AppointmentException("Appointment not found");
    }

    @Override
    public boolean isSlotAvailable(String timeSlot) {
        return !appointments.containsKey(timeSlot);
    }

    public String getDoctorId() { return doctorId; }
    public String getDoctorName() { return doctorName; }
    public String getSpecialization() { return specialization; }
    public int getAvailableSlotsCount() {
        return availableSlots.length - appointments.size();
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", availableSlots=" + getAvailableSlotsCount() +
                '}';
    }
}
