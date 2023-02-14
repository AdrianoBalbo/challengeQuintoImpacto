package com.example.challenge_backend.controllers;

import com.example.challenge_backend.dtos.CourseDTO;
import com.example.challenge_backend.dtos.TeacherCourseDTO;
import com.example.challenge_backend.models.Course;
import com.example.challenge_backend.models.DayTime;
import com.example.challenge_backend.services.CourseService;
import com.example.challenge_backend.services.TeacherCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    CourseService courseService;

    @Autowired
    TeacherCourseService teacherCourseService;

    @GetMapping("/courses")
    public List<CourseDTO> getCourses(){
        return courseService.getAllCourses().stream().map(course -> new CourseDTO(course)).collect(Collectors.toList());
    }

    @GetMapping("/courses/getteachers")
    public List<TeacherCourseDTO> getTeacherCourses(){
        return teacherCourseService.getAllTeacherCourse().stream().map(teacherCourse -> new TeacherCourseDTO(teacherCourse)).collect(Collectors.toList());
    }

    @PostMapping("/courses")
    public ResponseEntity<Object> createCourse(
            @RequestParam String courseName, @RequestParam DayTime dayTime
    ){
        if (courseName.isEmpty()||dayTime==null){
            return new ResponseEntity<>("Please fill all the areas", HttpStatus.FORBIDDEN);
        }
        Course course = new Course(courseName,dayTime);
        courseService.saveCourse(course);
        return new ResponseEntity<>("Course created", HttpStatus.CREATED);
    }

    @DeleteMapping("/courses/delete/{id}")
    public ResponseEntity<Object> deleteCourse(
            @PathVariable long id){
        courseService.deleteCourseById(id);
        return new ResponseEntity<>("Course deleted", HttpStatus.ACCEPTED);
    }

    @PatchMapping("/courses/update/{id}")
    public ResponseEntity<Object> updateCourse(
            @PathVariable long id, @RequestParam String courseName){
        Course course = courseService.findCourseById(id);
        if (course==null||courseName.isEmpty()){
            return new ResponseEntity<>("Data missing", HttpStatus.FORBIDDEN);
        }
        course.setCourseName(courseName);
        courseService.saveCourse(course);
        return new ResponseEntity<>("Course updated", HttpStatus.ACCEPTED);

    }
}
