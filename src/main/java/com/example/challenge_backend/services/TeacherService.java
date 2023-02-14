package com.example.challenge_backend.services;

import com.example.challenge_backend.models.Teacher;

import java.util.List;

public interface TeacherService {
    public List<Teacher> getAllTeachers();
    Teacher findTeacherByName (String firstName);
    Teacher findTeacherById (long id);

    void saveTeacher(Teacher teacher);


    void deleteTeacherById(long id);
}
