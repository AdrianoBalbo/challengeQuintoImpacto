package com.example.challenge_backend.controllers;

import com.example.challenge_backend.dtos.TeacherDTO;
import com.example.challenge_backend.models.Course;
import com.example.challenge_backend.models.Teacher;
import com.example.challenge_backend.models.TeacherCourse;
import com.example.challenge_backend.services.TeacherCourseService;
import com.example.challenge_backend.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TeacherController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    TeacherService teacherService;
    @Autowired
    TeacherCourseService teacherCourseService;

    @GetMapping("/teachers")
    public List<TeacherDTO> getTeachers(){
        return teacherService.getAllTeachers().stream().map(teacher -> new TeacherDTO(teacher)).collect(Collectors.toList());
    }

    @PostMapping("/teachers")
    public ResponseEntity<Object> registerTeacher(
            @RequestParam String firstName, @RequestParam String lastName,
            @RequestParam String email, @RequestParam String password
    ){
        if (firstName.isEmpty()||lastName.isEmpty()||email.isEmpty()||password.isEmpty()){
            return new ResponseEntity<>("Please fill all the areas", HttpStatus.FORBIDDEN);
        }
        Teacher teacher = new Teacher(firstName,lastName,email);
        teacherService.saveTeacher(teacher);
        return new ResponseEntity<>("Teacher registered",HttpStatus.CREATED);
    }

    @DeleteMapping("/teachers/delete/{id}")
    public ResponseEntity<Object> deleteTeacher(
            @PathVariable long id){
        teacherService.deleteTeacherById(id);
        return new ResponseEntity<>("Teacher deleted", HttpStatus.ACCEPTED);
    }

    @PatchMapping("/teachers/update/{id}")
    public ResponseEntity<Object> updateTeacher(
            @PathVariable long id, @RequestParam String firstName,
            @RequestParam String lastName, @RequestParam String email
    ){
        Teacher teacher = teacherService.findTeacherById(id);
        if (firstName.isEmpty()||lastName.isEmpty()||email.isEmpty()){
            return new ResponseEntity<>("Please fill all the areas",HttpStatus.FORBIDDEN);
        }
        if (teacher==null){
            return new ResponseEntity<>("Teacher not found", HttpStatus.FORBIDDEN);
        }
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setEmail(email);
        return new ResponseEntity<>("Teacher data updated",HttpStatus.ACCEPTED);
    }

    @PostMapping("/teachers/courses")
    public ResponseEntity<Object> assignCourseTeacher(
            @RequestParam Course course, @RequestParam Teacher teacher){
        if (course==null||teacher==null){
            return new ResponseEntity<>("Data missing", HttpStatus.FORBIDDEN);
        }
        TeacherCourse teacherCourse=new TeacherCourse(teacher,course);
        teacherCourseService.saveTeacherCourse(teacherCourse);
        return new ResponseEntity<>("Course assigned to teacher",HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/teachers/courses/delete/{id}")
    public ResponseEntity<Object> deleteCourseTeacher(
            @PathVariable long id){
        teacherCourseService.deleteTeacherCourseById(id);
        return new ResponseEntity<>("Course deleted from teacher",HttpStatus.ACCEPTED);
    }


}
