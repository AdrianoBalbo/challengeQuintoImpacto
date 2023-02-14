package com.example.challenge_backend.services.implementations;

import com.example.challenge_backend.models.Teacher;
import com.example.challenge_backend.repositories.TeacherRepository;
import com.example.challenge_backend.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findTeacherByName(String firstName) {
        return teacherRepository.findByFirstName(firstName);
    }

    @Override
    public Teacher findTeacherById(long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacherById(long id) {
        teacherRepository.deleteById(id);
    }


}
