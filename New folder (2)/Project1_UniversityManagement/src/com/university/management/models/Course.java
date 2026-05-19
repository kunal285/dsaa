package com.university.management.models;

/**
 * Course class representing a university course
 */
public final class Course {
    private final String courseId;
    private final String courseName;
    private final int credits;
    private final double maxGrade;

    /**
     * Constructor for Course
     * @param courseId unique course identifier
     * @param courseName name of the course
     * @param credits credit hours
     * @param maxGrade maximum grade for the course
     */
    public Course(String courseId, String courseName, int credits, double maxGrade) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.maxGrade = maxGrade;
    }

    // Getters
    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public double getMaxGrade() {
        return maxGrade;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", maxGrade=" + maxGrade +
                '}';
    }
}
