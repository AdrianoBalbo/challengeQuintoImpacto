package com.example.challenge_backend.repositories;

import com.example.challenge_backend.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseName(String courseName);
    Course findById(long id);
}
