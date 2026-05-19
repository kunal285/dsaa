package com.smarthome.devices.models;

import com.smarthome.devices.exceptions.DeviceException;

public final class Fan extends Device {
    private int speed; // 0-3

    public Fan(String deviceId, String deviceName) throws DeviceException {
        super(deviceId, deviceName);
        this.speed = 0;
    }

    public void setSpeed(int speed) throws DeviceException {
        if (speed < 0 || speed > 3) {
            throw new DeviceException("Fan speed must be between 0 and 3");
        }
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Fan{" +
                "deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", isOn=" + isOn +
                ", speed=" + speed +
                ", isOnline=" + isOnline +
                '}';
    }
}
