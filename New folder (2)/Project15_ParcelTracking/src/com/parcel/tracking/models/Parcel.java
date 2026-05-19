package com.parcel.tracking.models;

import java.time.LocalDateTime;

public final class Parcel {
    private final String parcelId;
    private final String trackingNumber;
    private String currentLocation;
    private String deliveryStatus;
    private final LocalDateTime shipDate;
    private static int parcelCounter = 0;

    public Parcel(String senderName, String recipientName) {
        this.parcelId = "PRC_" + (++parcelCounter);
        this.trackingNumber = "TRK_" + System.nanoTime();
        this.currentLocation = "Warehouse";
        this.deliveryStatus = "IN_TRANSIT";
        this.shipDate = LocalDateTime.now();
    }

    public void updateLocation(String location) { this.currentLocation = location; }
    public void updateStatus(String status) { this.deliveryStatus = status; }
    public String getParcelId() { return parcelId; }
    public String getTrackingNumber() { return trackingNumber; }
    public String getCurrentLocation() { return currentLocation; }
    public String getDeliveryStatus() { return deliveryStatus; }
}

class Courier {
    private final String courierId;
    private final String courierName;

    public Courier(String courierId, String courierName) {
        this.courierId = courierId;
        this.courierName = courierName;
    }

    public String getCourierId() { return courierId; }
    public String getCourierName() { return courierName; }
}
