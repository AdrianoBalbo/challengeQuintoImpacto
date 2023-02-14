package com.example.challenge_backend.controllers;


import com.example.challenge_backend.dtos.StudentDTO;
import com.example.challenge_backend.models.Course;
import com.example.challenge_backend.models.Student;
import com.example.challenge_backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class StudentsController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    StudentService studentsService;

    @GetMapping("/students")
    public List<StudentDTO> getStudents(){
        return studentsService.getAllStudents().stream().map(student -> new StudentDTO(student)).collect(Collectors.toList());
    }

    @PostMapping("/students")
    public ResponseEntity<Object> register(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String password
    ){
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()){
            return new ResponseEntity<>("Please fill all the areas", HttpStatus.FORBIDDEN);
        }
        if (studentsService.findStudentByEmail(email)!=null){
            return new ResponseEntity<>("Email already in use, try with another one", HttpStatus.FORBIDDEN);
        }

        Student student = new Student(firstName, lastName, email, password);
        studentsService.saveStudent(student);
        return new ResponseEntity<>("Student created", HttpStatus.CREATED);
    }

    @DeleteMapping("/students/delete/{id}")
    public ResponseEntity<Object> deleteStudent(
            @PathVariable long id
    ){
        studentsService.deleteStudentById(id);
        return new ResponseEntity<>("Student deleted", HttpStatus.ACCEPTED);
    }

    @PatchMapping("students/update/{id}")
    public ResponseEntity<Object> updateStudent(
            @PathVariable long id,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String password
    ){
        Student student = studentsService.findStudentById(id);
        if (firstName.isEmpty()||lastName.isEmpty()||email.isEmpty()||password.isEmpty()){
            return new ResponseEntity<>("Please fill all the areas", HttpStatus.FORBIDDEN);
        }
        if (student == null){
            return new ResponseEntity<>("Student not found", HttpStatus.FORBIDDEN);
        }
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setPassword(password);
        studentsService.saveStudent(student);
        return new ResponseEntity<>("Student updated", HttpStatus.ACCEPTED);
    }
}
