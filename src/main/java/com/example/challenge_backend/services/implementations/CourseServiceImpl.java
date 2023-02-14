package com.example.challenge_backend.services.implementations;

import com.example.challenge_backend.models.Course;
import com.example.challenge_backend.repositories.CourseRepository;
import com.example.challenge_backend.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;


    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course findCourseByName(String courseName) {
        return courseRepository.findByCourseName(courseName);
    }

    @Override
    public Course findCourseById(long id) {
        return courseRepository.findById(id);
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);

    }

    @Override
    public void deleteCourseById(long id) {
        courseRepository.deleteById(id);

    }
}
