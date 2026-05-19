package com.university.management.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Department class representing a university department
 */
public final class Department {
    private final String departmentId;
    private final String departmentName;
    private final String headOfDepartment;
    private final List<Course> courses;

    /**
     * Constructor for Department
     * @param departmentId unique department identifier
     * @param departmentName name of the department
     * @param headOfDepartment head of the department
     */
    public Department(String departmentId, String departmentName, String headOfDepartment) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.headOfDepartment = headOfDepartment;
        this.courses = new ArrayList<>();
    }

    /**
     * Add a course to the department
     * @param course course to add
     */
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    /**
     * Remove a course from the department
     * @param courseId ID of course to remove
     */
    public void removeCourse(String courseId) {
        courses.removeIf(course -> course.getCourseId().equals(courseId));
    }

    // Getters
    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getHeadOfDepartment() {
        return headOfDepartment;
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", headOfDepartment='" + headOfDepartment + '\'' +
                ", courses=" + courses.size() +
                '}';
    }
}
