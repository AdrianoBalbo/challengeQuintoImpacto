package com.example.challenge_backend.repositories;

import com.example.challenge_backend.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail (String email);
    Student findById(long id);
}
