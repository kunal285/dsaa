package com.university.management;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Concrete entity that stores the project-specific data.
 */
public class Student extends PersonRecord implements ExamEligibility, ScholarshipEligibility {
    private static final double EXAM_MIN_GPA = 5.0;
    private static final double SCHOLARSHIP_MIN_GPA = 8.0;
    private static final double SCHOLARSHIP_MAX_INCOME = 300000.0;

    private int attendance;
    private double gpa;
    private double familyIncome;
    private final ArrayList<Course> courses = new ArrayList<>();


    public Student(final String name, final int attendance, final double gpa, final double familyIncome) throws UniversityException {
        super(name);
        if (attendance < 0 || attendance > 100) {             throw new UniversityException("Attendance must be between 0 and 100.");         }         if (gpa < 0.0 || gpa > 10.0) {             throw new UniversityException("GPA must be between 0 and 10.");         }         if (familyIncome < 0.0) {             throw new UniversityException("Family income cannot be negative.");         }
        this.attendance = attendance;
        this.gpa = gpa;
        this.familyIncome = familyIncome;

    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(final int attendance) throws UniversityException {
        if (attendance < 0 || attendance > 100) {
            throw new UniversityException("Attendance must be between 0 and 100.");
        }
        this.attendance = attendance;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(final double gpa) throws UniversityException {
        if (gpa < 0.0 || gpa > 10.0) {
            throw new UniversityException("GPA must be between 0 and 10.");
        }
        this.gpa = gpa;
    }

    public double getFamilyIncome() {
        return familyIncome;
    }

    public void setFamilyIncome(final double familyIncome) throws UniversityException {
        if (familyIncome < 0.0) {
            throw new UniversityException("Family income cannot be negative.");
        }
        this.familyIncome = familyIncome;
    }

    public void addCourse(final Course course) throws UniversityException {
        if (course == null) {
            throw new UniversityException("Course cannot be null.");
        }

        courses.add(course);
        this.gpa = calculateGpa();
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    public double calculateGpa() {
        if (courses.isEmpty()) {
            return gpa;
        }

        double totalWeightedPoints = 0.0;
        double totalCredits = 0.0;
        for (Course course : courses) {
            totalWeightedPoints += course.getGradePoint() * course.getCredits();
            totalCredits += course.getCredits();
        }

        return totalCredits == 0.0 ? 0.0 : totalWeightedPoints / totalCredits;
    }

    @Override
    public boolean isExamEligible() {
        return attendance >= 75 && calculateGpa() >= EXAM_MIN_GPA;
    }

    @Override
    public boolean isScholarshipEligible() {
        return calculateGpa() >= SCHOLARSHIP_MIN_GPA && familyIncome <= SCHOLARSHIP_MAX_INCOME;
    }


    @Override
    public String describe() {
        return getBasicInfo() + ", attendance=" + attendance + ", gpa=" + calculateGpa() + ", familyIncome=" + familyIncome + ", courses=" + courses.size();
    }

    @Override
    public String toString() {
        return describe();
    }

    @Override
    public String getCategory() {
        return "Student";
    }
}