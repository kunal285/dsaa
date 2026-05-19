package com.railway.reservation.models;

import com.railway.reservation.exceptions.InvalidPassengerException;

/**
 * Passenger class representing a railway passenger
 */
public final class Passenger {
    private final String passengerId;
    private final String passengerName;
    private final int age;
    private final String email;
    private final String mobileNumber;

    /**
     * Constructor for Passenger
     * @param passengerId unique passenger identifier
     * @param passengerName passenger name
     * @param age passenger age
     * @param email passenger email
     * @param mobileNumber passenger mobile number
     * @throws InvalidPassengerException if any field is invalid
     */
    public Passenger(String passengerId, String passengerName, int age, String email, String mobileNumber)
            throws InvalidPassengerException {
        if (passengerId == null || passengerId.trim().isEmpty()) {
            throw new InvalidPassengerException("Passenger ID cannot be null or empty");
        }
        if (passengerName == null || passengerName.trim().isEmpty()) {
            throw new InvalidPassengerException("Passenger name cannot be null or empty");
        }
        if (age < 1 || age > 150) {
            throw new InvalidPassengerException("Invalid age: " + age + ". Age must be between 1 and 150");
        }
        if (email == null || !email.contains("@")) {
            throw new InvalidPassengerException("Invalid email format: " + email);
        }
        if (mobileNumber == null || mobileNumber.length() < 10) {
            throw new InvalidPassengerException("Invalid mobile number: " + mobileNumber);
        }

        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.age = age;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    // Getters
    public String getPassengerId() {
        return passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId='" + passengerId + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
