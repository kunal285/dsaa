package com.library.system.models;

/**
 * Abstract base class for library staff
 */
public abstract class LibraryStaff {
    protected final String staffId;
    protected final String staffName;
    protected final String designation;
    protected final String department;

    /**
     * Constructor for LibraryStaff
     * @param staffId unique staff identifier
     * @param staffName staff name
     * @param designation staff designation
     * @param department department name
     */
    public LibraryStaff(String staffId, String staffName, String designation, String department) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.designation = designation;
        this.department = department;
    }

    /**
     * Get staff information - will be overridden by subclasses
     * @return staff info
     */
    public abstract String getStaffInfo();

    /**
     * Perform duty - will be overridden by subclasses
     * @return duty description
     */
    public abstract String performDuty();

    // Getters
    public String getStaffId() {
        return staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDepartment() {
        return department;
    }
}
