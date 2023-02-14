package com.example.challenge_backend.dtos;

import com.example.challenge_backend.models.Teacher;

import java.util.Set;
import java.util.stream.Collectors;

public class TeacherDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<CourseDTO> courses;

    public TeacherDTO(){
    }



    public TeacherDTO(Teacher teachers){
        this.id = teachers.getId();
        this.firstName = teachers.getFirstName();
        this.lastName = teachers.getLastName();
        this.email = teachers.getEmail();
        this.courses = teachers.getCourses().stream().map(courses -> new CourseDTO(courses)).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Set<CourseDTO> getCourses() {
        return courses;
    }
}
