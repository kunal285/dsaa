package com.parcel.tracking;

/**
 * Represents a parcel location checkpoint.
 */
public class Location extends ParcelRecord {
    private final String city;
    private final String state;
    private final String pincode;

    public Location(final String name, final String city, final String state, final String pincode) throws ParcelException {
        super(name);
        if (city == null || city.trim().isEmpty()) {
            throw new ParcelException("City cannot be blank.");
        }
        if (state == null || state.trim().isEmpty()) {
            throw new ParcelException("State cannot be blank.");
        }
        if (pincode == null || pincode.trim().isEmpty()) {
            throw new ParcelException("Pincode cannot be blank.");
        }

        this.city = city.trim();
        this.state = state.trim();
        this.pincode = pincode.trim();
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPincode() {
        return pincode;
    }

    @Override
    public String getCategory() {
        return "Location";
    }

    @Override
    public String describe() {
        return getBasicInfo() + ", city=" + city + ", state=" + state + ", pincode=" + pincode;
    }

    @Override
    public String toString() {
        return describe();
    }
}