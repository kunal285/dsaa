package com.hospital.appointments.models;

import com.hospital.appointments.exceptions.AppointmentException;

public final class Patient {
    private final String patientId;
    private final String patientName;
    private final int age;
    private final String phoneNumber;

    public Patient(String patientId, String patientName, int age, String phoneNumber) 
            throws AppointmentException {
        if (patientId == null || patientId.isEmpty()) {
            throw new AppointmentException("Patient ID cannot be empty");
        }
        if (patientName == null || patientName.isEmpty()) {
            throw new AppointmentException("Patient name cannot be empty");
        }
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getPatientId() { return patientId; }
    public String getPatientName() { return patientName; }
    public int getAge() { return age; }
    public String getPhoneNumber() { return phoneNumber; }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId='" + patientId + '\'' +
                ", patientName='" + patientName + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
