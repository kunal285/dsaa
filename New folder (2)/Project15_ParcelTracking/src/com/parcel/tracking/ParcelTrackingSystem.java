package com.parcel.tracking;

import com.parcel.tracking.models.Parcel;

public class ParcelTrackingSystem {
    public static void main(String[] args) {
        System.out.println("=== Parcel Tracking System ===\n");
        Parcel parcel = new Parcel("Sender", "Recipient");
        parcel.updateLocation("Distribution Center");
        parcel.updateStatus("OUT_FOR_DELIVERY");
        System.out.println("✓ Parcel Tracking Number: " + parcel.getTrackingNumber());
        System.out.println("  Current Location: " + parcel.getCurrentLocation());
        System.out.println("  Status: " + parcel.getDeliveryStatus());
    }
}
