package com.example.challenge_backend.services.implementations;

import com.example.challenge_backend.models.TeacherCourse;
import com.example.challenge_backend.repositories.TeacherCourseRepository;
import com.example.challenge_backend.services.TeacherCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherCourseServiceImpl implements TeacherCourseService {
    @Autowired
    TeacherCourseRepository teacherCourseRepository;
    @Override
    public List<TeacherCourse> getAllTeacherCourse() {
        return teacherCourseRepository.findAll();
    }

    @Override
    public TeacherCourse findTeacherCourseById(long id) {
        return teacherCourseRepository.findById(id);
    }

    @Override
    public void saveTeacherCourse(TeacherCourse teacherCourse) {
        teacherCourseRepository.save(teacherCourse);
    }

    @Override
    public void deleteTeacherCourseById(long id) {
        teacherCourseRepository.deleteById(id);
    }
}
