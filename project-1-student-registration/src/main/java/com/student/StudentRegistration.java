package com.student;

import java.util.ArrayList;
import java.util.List;

public class StudentRegistration {

    private Student student;
    private List<Course> courses;

    public StudentRegistration(Student student) {
        this.student = student;
        this.courses = new ArrayList<>();
    }

    public boolean registerCourse(Course course) {
        if (courses.size() >= 5) {
            return false;
        }

        if (course.getCredits() < 1 || course.getCredits() > 6) {
            return false;
        }

        courses.add(course);
        return true;
    }

    public int getTotalCredits() {
        int total = 0;

        for (Course course : courses) {
            total += course.getCredits();
        }

        return total;
    }

    public int getCourseCount() {
        return courses.size();
    }

    public boolean isEligible() {
        int credits = getTotalCredits();
        return credits >= 12 && credits <= 24;
    }

    public Student getStudent() {
        return student;
    }
}