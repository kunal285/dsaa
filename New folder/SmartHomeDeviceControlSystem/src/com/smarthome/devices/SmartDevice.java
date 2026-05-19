package com.smarthome.devices;


/**
 * Concrete entity that stores the project-specific data.
 */
public class SmartDevice extends DeviceRecord implements Switchable, Configurable {
    private boolean powerOn;
    private int brightness;
    private String mode;


    public SmartDevice(final String name, final boolean powerOn, final int brightness, final String mode) throws SmartHomeException {
        super(name);
        if (brightness < 0 || brightness > 100) {             throw new SmartHomeException("Brightness must be between 0 and 100.");         }         if (mode == null || mode.trim().isEmpty()) {             throw new SmartHomeException("Mode cannot be blank.");         }
        this.powerOn = powerOn;
        this.brightness = brightness;
        this.mode = mode;

    }

    public boolean getPowerOn() {
        return powerOn;
    }

    public void setPowerOn(final boolean powerOn) throws SmartHomeException {
        this.powerOn = powerOn;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(final int brightness) throws SmartHomeException {
        if (brightness < 0 || brightness > 100) {
            throw new SmartHomeException("Brightness must be between 0 and 100.");
        }
        this.brightness = brightness;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(final String mode) throws SmartHomeException {
        if (mode == null || mode.trim().isEmpty()) {
            throw new SmartHomeException("Mode cannot be blank.");
        }
        this.mode = mode;
    }

    @Override
    public void turnOn() {
        powerOn = true;
    }

    @Override
    public void turnOff() {
        powerOn = false;
    }

    @Override
    public void configureMode(final String mode) {
        this.mode = mode;
    }

    @Override
    public String currentConfiguration() {
        return "Mode=" + mode + ", Brightness=" + brightness + ", Power=" + powerOn;
    }


    public String describe() {
        return getBasicInfo() + ", " + "powerOn=" + powerOn + ", " + "brightness=" + brightness + ", " + "mode=" + mode;
    }

    @Override
    public String toString() {
        return describe();
    }

    @Override
    public String getCategory() {
        return "SmartDevice";
    }
}