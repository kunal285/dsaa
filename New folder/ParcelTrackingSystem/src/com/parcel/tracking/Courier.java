package com.parcel.tracking;

/**
 * Represents the courier responsible for delivery.
 */
public class Courier extends ParcelRecord {
    private final String employeeCode;
    private final int averageStopsPerDay;

    public Courier(final String name, final String employeeCode, final int averageStopsPerDay) throws ParcelException {
        super(name);
        if (employeeCode == null || employeeCode.trim().isEmpty()) {
            throw new ParcelException("Employee code cannot be blank.");
        }
        if (averageStopsPerDay < 1) {
            throw new ParcelException("Average stops per day must be at least 1.");
        }

        this.employeeCode = employeeCode.trim();
        this.averageStopsPerDay = averageStopsPerDay;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public int getAverageStopsPerDay() {
        return averageStopsPerDay;
    }

    public int predictDeliveryDays(final int distanceUnits) throws ParcelException {
        if (distanceUnits < 1) {
            throw new ParcelException("Distance units must be at least 1.");
        }

        return Math.max(1, distanceUnits / averageStopsPerDay + 1);
    }

    @Override
    public String getCategory() {
        return "Courier";
    }

    @Override
    public String describe() {
        return getBasicInfo() + ", employeeCode=" + employeeCode + ", averageStopsPerDay=" + averageStopsPerDay;
    }

    @Override
    public String toString() {
        return describe();
    }
}