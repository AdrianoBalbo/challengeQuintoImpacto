package com.example.challenge_backend.services;

import com.example.challenge_backend.models.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getAllCourses();

    Course findCourseByName(String courseName);
    Course findCourseById(long id);

    void saveCourse(Course course);
    void deleteCourseById(long id);
}
