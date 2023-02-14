package com.example.challenge_backend.repositories;

import com.example.challenge_backend.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findByFirstName(String firstName);
    Teacher findByEmail(String email);
    Teacher findById(long id);
}
