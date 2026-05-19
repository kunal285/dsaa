package com.smarthome.devices.interfaces;

import com.smarthome.devices.exceptions.DeviceException;

public interface Switchable {
    void turnOn() throws DeviceException;
    void turnOff() throws DeviceException;
    boolean isOn();
}
