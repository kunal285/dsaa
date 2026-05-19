package com.railway.reservation;

/**
 * Represents a passenger booking a train.
 */
public class Passenger extends TravelRecord {
    private final int age;
    private final String gender;

    public Passenger(final String name, final int age, final String gender) throws RailwayException {
        super(name);
        if (age < 1) {
            throw new RailwayException("Passenger age must be positive.");
        }
        if (gender == null || gender.trim().isEmpty()) {
            throw new RailwayException("Gender cannot be blank.");
        }

        this.age = age;
        this.gender = gender.trim();
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String getCategory() {
        return "Passenger";
    }

    @Override
    public String describe() {
        return getBasicInfo() + ", age=" + age + ", gender=" + gender;
    }

    @Override
    public String toString() {
        return describe();
    }
}