package com.parcel.tracking;


/**
 * Parcel that can be tracked through locations and courier prediction.
 */
public class Parcel extends ParcelRecord implements Trackable {
    private final String trackingNumber;
    private String currentStatus;
    private final boolean priority;
    private Location currentLocation;
    private final Courier courier;

    public Parcel(final String name, final String trackingNumber, final String currentStatus, final boolean priority, final Location currentLocation, final Courier courier) throws ParcelException {
        super(name);
        if (trackingNumber == null || trackingNumber.trim().isEmpty()) {
            throw new ParcelException("Tracking number cannot be blank.");
        }
        if (currentStatus == null || currentStatus.trim().isEmpty()) {
            throw new ParcelException("Current status cannot be blank.");
        }
        if (currentLocation == null) {
            throw new ParcelException("Location cannot be null.");
        }
        if (courier == null) {
            throw new ParcelException("Courier cannot be null.");
        }

        this.trackingNumber = trackingNumber.trim();
        this.currentStatus = currentStatus.trim();
        this.priority = priority;
        this.currentLocation = currentLocation;
        this.courier = courier;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public boolean isPriority() {
        return priority;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public Courier getCourier() {
        return courier;
    }

    public int predictDeliveryDays(final int distanceUnits) throws ParcelException {
        return courier.predictDeliveryDays(distanceUnits);
    }

    @Override
    public String track() {
        return "Tracking " + trackingNumber + ": " + currentStatus + " @ " + currentLocation.getCity();
    }

    @Override
    public void updateStatus(final String status) {
        currentStatus = status;
    }

    public void updateLocation(final Location location) throws ParcelException {
        if (location == null) {
            throw new ParcelException("Location cannot be null.");
        }

        this.currentLocation = location;
    }

    @Override
    public String getCategory() {
        return "Parcel";
    }

    @Override
    public String describe() {
        return getBasicInfo() + ", trackingNumber=" + trackingNumber + ", currentStatus=" + currentStatus + ", priority=" + priority + ", currentLocation=" + currentLocation.getCity() + ", courier=" + courier.getName();
    }

    @Override
    public String toString() {
        return describe();
    }
}