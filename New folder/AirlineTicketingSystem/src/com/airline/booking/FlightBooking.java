package com.airline.booking;


/**
 * Concrete entity that stores the project-specific data.
 */
public class FlightBooking extends PassengerRecord implements CheckIn {
    private String flightNumber;
    private String seatNumber;
    private boolean checkedIn;


    public FlightBooking(final String name, final String flightNumber, final String seatNumber, final boolean checkedIn) throws AirlineException {
        super(name);
        if (flightNumber == null || flightNumber.trim().isEmpty()) {             throw new AirlineException("Flight number cannot be blank.");         }         if (seatNumber == null || seatNumber.trim().isEmpty()) {             throw new AirlineException("Seat number cannot be blank.");         }
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.checkedIn = checkedIn;

    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(final String flightNumber) throws AirlineException {
        if (flightNumber == null || flightNumber.trim().isEmpty()) {
            throw new AirlineException("Flight number cannot be blank.");
        }
        this.flightNumber = flightNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(final String seatNumber) throws AirlineException {
        if (seatNumber == null || seatNumber.trim().isEmpty()) {
            throw new AirlineException("Seat number cannot be blank.");
        }
        this.seatNumber = seatNumber;
    }

    public boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(final boolean checkedIn) throws AirlineException {
        this.checkedIn = checkedIn;
    }

    @Override
    public boolean checkIn() {
        checkedIn = true; return true;
    }

    @Override
    public String boardingPass() {
        return checkedIn ? "Boarding pass ready for flight " + flightNumber + ", seat " + seatNumber : "Please complete check-in first.";
    }


    public String describe() {
        return getBasicInfo() + ", " + "flightNumber=" + flightNumber + ", " + "seatNumber=" + seatNumber + ", " + "checkedIn=" + checkedIn;
    }

    @Override
    public String toString() {
        return describe();
    }

    @Override
    public String getCategory() {
        return "FlightBooking";
    }
}