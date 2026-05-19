package com.smarthome.devices;

import com.smarthome.devices.exceptions.DeviceException;
import com.smarthome.devices.models.Fan;
import com.smarthome.devices.models.Light;

public class SmartHomeControlSystem {
    public static void main(String[] args) {
        try {
            System.out.println("=== Smart Home Device Control System ===\n");

            Light light1 = new Light("L001", "Living Room Light");
            Light light2 = new Light("L002", "Bedroom Light");
            Fan fan1 = new Fan("F001", "Hall Fan");

            System.out.println("--- Devices ---");
            System.out.println(light1);
            System.out.println(light2);
            System.out.println(fan1);

            System.out.println("\n--- Controlling Devices ---");
            light1.turnOn();
            light1.setBrightness(75);
            System.out.println("✓ Light1 turned on at 75% brightness");

            light2.turnOn();
            light2.setBrightness(50);
            System.out.println("✓ Light2 turned on at 50% brightness");

            fan1.turnOn();
            fan1.setSpeed(2);
            System.out.println("✓ Fan1 turned on at speed 2");

            System.out.println("\n--- Device Status ---");
            System.out.println(light1);
            System.out.println(light2);
            System.out.println(fan1);

            System.out.println("\n--- Testing Invalid Operations ---");
            testInvalidBrightness(light1);
            testInvalidSpeed(fan1);
            testOfflineDevice(light1);

        } catch (DeviceException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void testInvalidBrightness(Light light) {
        try {
            System.out.println("Attempting to set invalid brightness (150%)...");
            light.setBrightness(150);
        } catch (DeviceException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }

    private static void testInvalidSpeed(Fan fan) {
        try {
            System.out.println("Attempting to set invalid speed (5)...");
            fan.setSpeed(5);
        } catch (DeviceException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }

    private static void testOfflineDevice(Light light) {
        try {
            System.out.println("Attempting to turn on offline device...");
            light.setOnline(false);
            light.turnOn();
        } catch (DeviceException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }
}
