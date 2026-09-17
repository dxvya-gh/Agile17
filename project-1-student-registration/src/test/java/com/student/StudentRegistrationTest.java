package com.student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRegistrationTest {

    @Test
    void studentShouldRegisterCourse() {
        Student student = new Student("S101", "Arun", 19);
        StudentRegistration registration = new StudentRegistration(student);

        Course course = new Course("Data Structures", 4);

        assertTrue(registration.registerCourse(course));
        assertEquals(1, registration.getCourseCount());
        assertEquals(4, registration.getTotalCredits());
    }

    @Test
    void studentShouldBeEligibleWithValidCredits() {
        Student student = new Student("S102", "Rahul", 20);
        StudentRegistration registration = new StudentRegistration(student);

        registration.registerCourse(new Course("DSA", 4));
        registration.registerCourse(new Course("DBMS", 4));
        registration.registerCourse(new Course("OS", 4));

        assertEquals(12, registration.getTotalCredits());
        assertTrue(registration.isEligible());
    }

    @Test
    void studentShouldNotRegisterMoreThanFiveCourses() {
        Student student = new Student("S103", "Kiran", 19);
        StudentRegistration registration = new StudentRegistration(student);

        for (int i = 1; i <= 5; i++) {
            assertTrue(registration.registerCourse(
                    new Course("Course " + i, 3)
            ));
        }

        assertFalse(registration.registerCourse(
                new Course("Course 6", 3)
        ));

        assertEquals(5, registration.getCourseCount());
    }

    @Test
    void invalidCreditValueShouldBeRejected() {
        Student student = new Student("S104", "Vijay", 20);
        StudentRegistration registration = new StudentRegistration(student);

        assertFalse(registration.registerCourse(
                new Course("Invalid Course", 7)
        ));

        assertEquals(0, registration.getCourseCount());
    }
}