package com.airline.booking.models;

import com.airline.booking.exceptions.FlightException;

public final class Passenger {
    private final String passengerId;
    private final String passengerName;
    private final int age;
    private final String passportNumber;

    public Passenger(String passengerId, String passengerName, int age, String passportNumber)
            throws FlightException {
        if (passengerId == null || passengerId.isEmpty()) {
            throw new FlightException("Passenger ID cannot be empty");
        }
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.age = age;
        this.passportNumber = passportNumber;
    }

    public String getPassengerId() { return passengerId; }
    public String getPassengerName() { return passengerName; }
    public int getAge() { return age; }
    public String getPassportNumber() { return passportNumber; }

    @Override
    public String toString() {
        return "Passenger{" + "name='" + passengerName + '\'' + '}';
    }
}
