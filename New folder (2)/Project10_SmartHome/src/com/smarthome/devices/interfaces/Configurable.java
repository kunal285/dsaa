package com.smarthome.devices.interfaces;

import com.smarthome.devices.exceptions.DeviceException;

public interface Configurable {
    void setConfiguration(String key, String value) throws DeviceException;
    String getConfiguration(String key);
}
