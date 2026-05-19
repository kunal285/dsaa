package com.hospital.appointments;


/**
 * Concrete entity that stores the project-specific data.
 */
public class Appointment extends AppointmentRecord implements Schedulable {
    private String doctorName;
    private String appointmentDate;
    private boolean urgent;


    public Appointment(final String name, final String doctorName, final String appointmentDate, final boolean urgent) throws AppointmentException {
        super(name);
        if (doctorName == null || doctorName.trim().isEmpty()) {             throw new AppointmentException("Doctor name cannot be blank.");         }         if (appointmentDate == null || appointmentDate.trim().isEmpty()) {             throw new AppointmentException("Appointment date cannot be blank.");         }
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.urgent = urgent;

    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(final String doctorName) throws AppointmentException {
        if (doctorName == null || doctorName.trim().isEmpty()) {
            throw new AppointmentException("Doctor name cannot be blank.");
        }
        this.doctorName = doctorName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(final String appointmentDate) throws AppointmentException {
        if (appointmentDate == null || appointmentDate.trim().isEmpty()) {
            throw new AppointmentException("Appointment date cannot be blank.");
        }
        this.appointmentDate = appointmentDate;
    }

    public boolean getUrgent() {
        return urgent;
    }

    public void setUrgent(final boolean urgent) throws AppointmentException {
        this.urgent = urgent;
    }

    @Override
    public boolean scheduleAppointment() {
        return true;
    }

    @Override
    public String appointmentSummary() {
        return "Appointment with Dr. " + doctorName + " on " + appointmentDate + (urgent ? " [Urgent]" : "");
    }


    public String describe() {
        return getBasicInfo() + ", " + "doctorName=" + doctorName + ", " + "appointmentDate=" + appointmentDate + ", " + "urgent=" + urgent;
    }

    @Override
    public String toString() {
        return describe();
    }

    @Override
    public String getCategory() {
        return "Appointment";
    }
}