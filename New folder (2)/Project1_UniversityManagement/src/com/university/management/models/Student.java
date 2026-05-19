package com.university.management.models;

import com.university.management.exceptions.InvalidGPAException;
import com.university.management.exceptions.InvalidGradeException;
import com.university.management.interfaces.ExamEligibility;
import com.university.management.interfaces.ScholarshipEligibility;
import java.util.HashMap;
import java.util.Map;

/**
 * Student class representing a university student
 */
public class Student implements ExamEligibility, ScholarshipEligibility {

    public static double getMIN_ATTENDANCE() {
        return MIN_ATTENDANCE;
    }
    private final String studentId;
    private final String studentName;
    private final int enrollmentYear;
    private final Department department;
    private double gpa;
    private static final double MIN_ATTENDANCE = 75.0;
    private static final double EXAM_ELIGIBLE_GPA = 2.0;
    private static final double SCHOLARSHIP_GPA = 3.5;
    private static final double SCHOLARSHIP_AMOUNT = 10000.0;
    private final Map<String, Double> courseGrades;

    /**
     * Constructor for Student
     * @param studentId unique student identifier
     * @param studentName name of the student
     * @param enrollmentYear year of enrollment
     * @param department department of the student
     * @throws InvalidGPAException if GPA is invalid
     */
    public Student(String studentId, String studentName, int enrollmentYear, Department department) 
            throws InvalidGPAException {
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new InvalidGPAException("Student ID cannot be null or empty");
        }
        this.studentId = studentId;
        this.studentName = studentName;
        this.enrollmentYear = enrollmentYear;
        this.department = department;
        this.gpa = 0.0;
        this.courseGrades = new HashMap<>();
    }

    /**
     * Add a grade for a course
     * @param courseId course ID
     * @param grade grade value
     * @throws InvalidGradeException if grade is out of range
     */
    public void addCourseGrade(String courseId, double grade) throws InvalidGradeException {
        if (grade < 0.0 || grade > 4.0) {
            throw new InvalidGradeException("Grade must be between 0.0 and 4.0, received: " + grade);
        }
        this.courseGrades.put(courseId, grade);
        calculateGPA();
    }

    /**
     * Calculate GPA based on all course grades
     */
    private void calculateGPA() {
        if (courseGrades.isEmpty()) {
            this.gpa = 0.0;
            return;
        }
        double totalGPA = courseGrades.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        this.gpa = totalGPA / courseGrades.size();
    }

    /**
     * Set GPA manually
     * @param gpa GPA value
     * @throws InvalidGPAException if GPA is out of range
     */
    public void setGPA(double gpa) throws InvalidGPAException {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new InvalidGPAException("GPA must be between 0.0 and 4.0, received: " + gpa);
        }
        this.gpa = gpa;
    }

    @Override
    public boolean isEligibleForExam() {
        return this.gpa >= EXAM_ELIGIBLE_GPA;
    }

    @Override
    public String getEligibilityMessage() {
        if (isEligibleForExam()) {
            return "Student " + this.studentName + " is eligible for exam. Current GPA: " + this.gpa;
        }
        return "Student " + this.studentName + " is NOT eligible for exam. Current GPA: " + this.gpa + 
               ". Minimum required: " + EXAM_ELIGIBLE_GPA;
    }

    @Override
    public boolean isEligibleForScholarship() {
        return this.gpa >= SCHOLARSHIP_GPA;
    }

    @Override
    public double getScholarshipAmount() {
        if (isEligibleForScholarship()) {
            return SCHOLARSHIP_AMOUNT;
        }
        return 0.0;
    }

    @Override
    public String getScholarshipMessage() {
        if (isEligibleForScholarship()) {
            return "Student " + this.studentName + " is eligible for scholarship of Rs. " + SCHOLARSHIP_AMOUNT;
        }
        return "Student " + this.studentName + " is NOT eligible for scholarship. Current GPA: " + this.gpa + 
               ". Minimum required: " + SCHOLARSHIP_GPA;
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public Department getDepartment() {
        return department;
    }

    public double getGpa() {
        return gpa;
    }

    public Map<String, Double> getCourseGrades() {
        return new HashMap<>(courseGrades);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", enrollmentYear=" + enrollmentYear +
                ", department=" + department.getDepartmentName() +
                ", gpa=" + String.format("%.2f", gpa) +
                '}';
    }
}
