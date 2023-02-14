package com.example.challenge_backend.services;

import com.example.challenge_backend.models.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();

    Student findStudentByEmail(String email);
    Student findStudentById (long id);

    void saveStudent(Student student);
    void deleteStudentById(long id);
}
