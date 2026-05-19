package com.smarthome.devices.models;

import com.smarthome.devices.exceptions.DeviceException;

public final class Light extends Device {
    private int brightness;

    public Light(String deviceId, String deviceName) throws DeviceException {
        super(deviceId, deviceName);
        this.brightness = 0;
    }

    public void setBrightness(int brightness) throws DeviceException {
        if (brightness < 0 || brightness > 100) {
            throw new DeviceException("Brightness must be between 0 and 100");
        }
        this.brightness = brightness;
    }

    public int getBrightness() {
        return brightness;
    }

    @Override
    public String toString() {
        return "Light{" +
                "deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", isOn=" + isOn +
                ", brightness=" + brightness + "%" +
                ", isOnline=" + isOnline +
                '}';
    }
}
