package com.university.management;

import com.university.management.exceptions.InvalidGPAException;
import com.university.management.exceptions.InvalidGradeException;
import com.university.management.models.Course;
import com.university.management.models.Department;
import com.university.management.models.Student;

/**
 * Main class for University Student Management System
 */
public class UniversityManagementSystem {
    public static void main(String[] args) {
        try {
            // Create a department
            Department csDepartment = new Department("CS101", "Computer Science", "Dr. John Smith");

            // Create courses
            Course dataStructures = new Course("CS201", "Data Structures", 4, 4.0);
            Course algorithms = new Course("CS202", "Algorithms", 4, 4.0);
            Course database = new Course("CS203", "Database Management", 3, 4.0);

            // Add courses to department
            csDepartment.addCourse(dataStructures);
            csDepartment.addCourse(algorithms);
            csDepartment.addCourse(database);

            // Create students
            Student student1 = new Student("S001", "Alice Johnson", 2024, csDepartment);
            Student student2 = new Student("S002", "Bob Wilson", 2023, csDepartment);
            Student student3 = new Student("S003", "Charlie Brown", 2024, csDepartment);

            // Add grades for student1 (eligible for both exam and scholarship)
            student1.addCourseGrade("CS201", 3.9);
            student1.addCourseGrade("CS202", 3.8);
            student1.addCourseGrade("CS203", 3.7);

            // Add grades for student2 (eligible for exam but not scholarship)
            student2.addCourseGrade("CS201", 2.5);
            student2.addCourseGrade("CS202", 2.3);
            student2.addCourseGrade("CS203", 2.1);

            // Add grades for student3 (not eligible)
            student3.addCourseGrade("CS201", 1.8);
            student3.addCourseGrade("CS202", 1.9);

            // Display student information and eligibility
            System.out.println("=== University Student Management System ===\n");
            System.out.println("Department: " + csDepartment.getDepartmentName());
            System.out.println("Head: " + csDepartment.getHeadOfDepartment());
            System.out.println("Total Courses: " + csDepartment.getCourses().size());
            System.out.println("\n--- Student Details ---\n");

            displayStudentInfo(student1);
            System.out.println();
            displayStudentInfo(student2);
            System.out.println();
            displayStudentInfo(student3);

            // Test invalid inputs
            System.out.println("\n--- Testing Invalid Inputs ---\n");
            testInvalidGrades();
            testInvalidGPA();

        } catch (InvalidGPAException | InvalidGradeException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Display student information
     */
    private static void displayStudentInfo(Student student) {
        System.out.println(student);
        System.out.println("  GPA: " + String.format("%.2f", student.getGpa()));
        System.out.println("  Exam Eligibility: " + student.getEligibilityMessage());
        System.out.println("  Scholarship Eligibility: " + student.getScholarshipMessage());
    }

    /**
     * Test invalid grade input
     */
    private static void testInvalidGrades() {
        try {
            Department testDept = new Department("T001", "Test", "Test Head");
            Student student = new Student("T001", "Test Student", 2024, testDept);
            System.out.println("Attempting to add invalid grade (5.0)...");
            student.addCourseGrade("CS201", 5.0);
        } catch (InvalidGradeException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        } catch (InvalidGPAException e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    /**
     * Test invalid GPA input
     */
    private static void testInvalidGPA() {
        try {
            Department testDept = new Department("T001", "Test", "Test Head");
            Student student = new Student("T001", "Test Student", 2024, testDept);
            System.out.println("Attempting to set invalid GPA (-1.0)...");
            student.setGPA(-1.0);
        } catch (InvalidGPAException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }
}
