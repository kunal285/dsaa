package com.smarthome.devices.interfaces;

import com.smarthome.devices.exceptions.DeviceException;

public interface Switchable {
    void turnOn() throws DeviceException;
    void turnOff() throws DeviceException;
    boolean isOn();
}

public interface SmartDevice {
    void setConfiguration(String key, String value) throws DeviceException;
    String getConfiguration(String key);
}
