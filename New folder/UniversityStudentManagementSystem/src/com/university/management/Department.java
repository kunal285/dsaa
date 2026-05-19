package com.university.management;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a university department that manages courses.
 */
public class Department extends PersonRecord {
    private final String headOfDepartment;
    private final ArrayList<Course> courses = new ArrayList<>();

    public Department(final String name, final String headOfDepartment) throws UniversityException {
        super(name);
        if (headOfDepartment == null || headOfDepartment.trim().isEmpty()) {
            throw new UniversityException("Head of department cannot be blank.");
        }

        this.headOfDepartment = headOfDepartment.trim();
    }

    public String getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void addCourse(final Course course) throws UniversityException {
        if (course == null) {
            throw new UniversityException("Course cannot be null.");
        }

        courses.add(course);
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    public int getCourseCount() {
        return courses.size();
    }

    @Override
    public String getCategory() {
        return "Department";
    }

    @Override
    public String describe() {
        return getBasicInfo() + ", headOfDepartment=" + headOfDepartment + ", courseCount=" + courses.size();
    }

    @Override
    public String toString() {
        return describe();
    }
}