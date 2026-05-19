package com.hospital.appointments.models;

import java.time.LocalDateTime;

public final class Appointment {
    private final String appointmentId;
    private final String patientId;
    private final String doctorId;
    private final String timeSlot;
    private final LocalDateTime bookingDate;
    private static final String CONFIRMED = "CONFIRMED";
    private static final String CANCELLED = "CANCELLED";
    private String status;

    public Appointment(String appointmentId, String patientId, String doctorId, String timeSlot) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.timeSlot = timeSlot;
        this.bookingDate = LocalDateTime.now();
        this.status = CONFIRMED;
    }

    public void cancel() {
        this.status = CANCELLED;
    }

    public String getAppointmentId() { return appointmentId; }
    public String getPatientId() { return patientId; }
    public String getDoctorId() { return doctorId; }
    public String getTimeSlot() { return timeSlot; }
    public LocalDateTime getBookingDate() { return bookingDate; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", timeSlot='" + timeSlot + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
