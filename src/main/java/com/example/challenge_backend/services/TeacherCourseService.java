package com.example.challenge_backend.services;

import com.example.challenge_backend.models.TeacherCourse;

import java.util.List;

public interface TeacherCourseService {
    public List<TeacherCourse> getAllTeacherCourse();

    TeacherCourse findTeacherCourseById(long id);

    void saveTeacherCourse(TeacherCourse teacherCourse);

    void deleteTeacherCourseById(long id);
}
