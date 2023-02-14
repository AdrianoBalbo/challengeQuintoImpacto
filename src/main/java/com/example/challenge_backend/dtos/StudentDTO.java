package com.example.challenge_backend.dtos;

import com.example.challenge_backend.models.Course;
import com.example.challenge_backend.models.Student;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Set;
import java.util.stream.Collectors;

public class StudentDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private Set<CourseDTO> courses;

    public StudentDTO() {
    }

    public StudentDTO(Student students){
        this.id = students.getId();
        this.firstName = students.getFirstName();
        this.lastName = students.getLastName();
        this.email = students.getEmail();
        this.courses = students.getCourse().stream().map(course -> new CourseDTO(course)).collect(Collectors.toSet());
    }

    public long getId() {
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
