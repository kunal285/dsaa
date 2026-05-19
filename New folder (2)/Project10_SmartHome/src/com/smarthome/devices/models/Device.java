package com.smarthome.devices.models;

import com.smarthome.devices.exceptions.DeviceException;
import com.smarthome.devices.interfaces.Configurable;
import com.smarthome.devices.interfaces.Switchable;

import java.util.HashMap;
import java.util.Map;

public abstract class Device implements Switchable, Configurable {
    protected final String deviceId;
    protected final String deviceName;
    protected boolean isOn;
    protected boolean isOnline;
    protected final Map<String, String> configuration;

    public Device(String deviceId, String deviceName) throws DeviceException {
        if (deviceId == null || deviceId.isEmpty()) {
            throw new DeviceException("Device ID cannot be empty");
        }
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.isOn = false;
        this.isOnline = true;
        this.configuration = new HashMap<>();
    }

    @Override
    public void turnOn() throws DeviceException {
        if (!isOnline) {
            throw new DeviceException("Device is offline");
        }
        this.isOn = true;
    }

    @Override
    public void turnOff() throws DeviceException {
        this.isOn = false;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    
    public void setConfiguration(String key, String value) throws DeviceException {
        if (key == null || key.isEmpty()) {
            throw new DeviceException("Configuration key cannot be empty");
        }
        this.configuration.put(key, value);
    }

    @Override
    public String getConfiguration(String key) {
        return this.configuration.getOrDefault(key, "NOT SET");
    }

    public String getDeviceId() { return deviceId; }
    public String getDeviceName() { return deviceName; }
    public boolean isOnline() { return isOnline; }
    public void setOnline(boolean online) { this.isOnline = online; }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", isOn=" + isOn +
                ", isOnline=" + isOnline +
                '}';
    }
}
