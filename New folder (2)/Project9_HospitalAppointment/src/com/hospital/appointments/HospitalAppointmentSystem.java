package com.hospital.appointments;

import com.hospital.appointments.exceptions.AppointmentException;
import com.hospital.appointments.models.Appointment;
import com.hospital.appointments.models.Doctor;
import com.hospital.appointments.models.Patient;

public class HospitalAppointmentSystem {
    public static void main(String[] args) {
        try {
            System.out.println("=== Hospital Appointment Booking System ===\n");

            Doctor doctor1 = new Doctor("D001", "Dr. Sharma", "Cardiology");
            Doctor doctor2 = new Doctor("D002", "Dr. Patel", "Neurology");

            System.out.println("--- Doctors ---");
            System.out.println(doctor1);
            System.out.println(doctor2);

            Patient patient1 = new Patient("P001", "Rajesh Kumar", 45, "9876543210");
            Patient patient2 = new Patient("P002", "Priya Singh", 35, "9123456789");
            Patient patient3 = new Patient("P003", "Aman Patel", 50, "9988776655");

            System.out.println("\n--- Booking Appointments ---");
            doctor1.bookAppointment(patient1.getPatientId(), "09:00");
            System.out.println("✓ Booked appointment for " + patient1.getPatientName() + " at 09:00");

            doctor1.bookAppointment(patient2.getPatientId(), "09:30");
            System.out.println("✓ Booked appointment for " + patient2.getPatientName() + " at 09:30");

            doctor2.bookAppointment(patient3.getPatientId(), "10:00");
            System.out.println("✓ Booked appointment for " + patient3.getPatientName() + " at 10:00");

            System.out.println("\n--- Available Slots ---");
            System.out.println("Dr. Sharma - Available slots: " + doctor1.getAvailableSlotsCount());
            System.out.println("Dr. Patel - Available slots: " + doctor2.getAvailableSlotsCount());

            System.out.println("\n--- Testing Invalid Operations ---");
            testDuplicateBooking(doctor1, patient1);
            testInvalidPatient();

        } catch (AppointmentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void testDuplicateBooking(Doctor doctor, Patient patient) {
        try {
            System.out.println("Attempting to book same slot twice...");
            doctor.bookAppointment(patient.getPatientId(), "09:00");
        } catch (AppointmentException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }

    private static void testInvalidPatient() {
        try {
            System.out.println("Attempting to create patient with empty name...");
            Patient invalidPatient = new Patient("P099", "", 30, "9999999999");
            invalidPatient.toString(); // referenced to silence analyzer
        } catch (AppointmentException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }
}
