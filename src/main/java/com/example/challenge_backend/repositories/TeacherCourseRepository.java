package com.example.challenge_backend.repositories;

import com.example.challenge_backend.models.Teacher;
import com.example.challenge_backend.models.TeacherCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TeacherCourseRepository extends JpaRepository<TeacherCourse, Long> {
    TeacherCourse findById(long id);
}
