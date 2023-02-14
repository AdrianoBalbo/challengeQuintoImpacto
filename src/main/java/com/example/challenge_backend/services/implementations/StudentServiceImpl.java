package com.example.challenge_backend.services.implementations;

import com.example.challenge_backend.models.Student;
import com.example.challenge_backend.repositories.StudentRepository;
import com.example.challenge_backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentsRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public Student findStudentByEmail(String email) {
        return studentsRepository.findByEmail(email);
    }

    @Override
    public Student findStudentById(long id) {
        return studentsRepository.findById(id);
    }

    @Override
    public void saveStudent(Student student) {
        studentsRepository.save(student);

    }

    @Override
    public void deleteStudentById(long id) {
        studentsRepository.deleteById(id);
    }
}
