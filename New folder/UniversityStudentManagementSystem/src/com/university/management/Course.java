package com.university.management;

/**
 * Represents a single course and its scored performance.
 */
public class Course extends PersonRecord {
    private static final double MAX_MARKS = 100.0;
    private static final double MAX_GRADE_POINT = 10.0;

    private final int credits;
    private double marks;

    public Course(final String name, final int credits, final double marks) throws UniversityException {
        super(name);
        if (credits < 1) {
            throw new UniversityException("Credits must be at least 1.");
        }
        if (marks < 0.0 || marks > MAX_MARKS) {
            throw new UniversityException("Marks must be between 0 and 100.");
        }

        this.credits = credits;
        this.marks = marks;
    }

    public int getCredits() {
        return credits;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(final double marks) throws UniversityException {
        if (marks < 0.0 || marks > MAX_MARKS) {
            throw new UniversityException("Marks must be between 0 and 100.");
        }

        this.marks = marks;
    }

    public double getGradePoint() {
        return Math.min(MAX_GRADE_POINT, marks / 10.0);
    }

    @Override
    public String getCategory() {
        return "Course";
    }

    @Override
    public String describe() {
        return getBasicInfo() + ", credits=" + credits + ", marks=" + marks + ", gradePoint=" + getGradePoint();
    }

    @Override
    public String toString() {
        return describe();
    }
}