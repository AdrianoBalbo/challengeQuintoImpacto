package com.example.challenge_backend.dtos;

import com.example.challenge_backend.models.DayTime;
import com.example.challenge_backend.models.TeacherCourse;

public class TeacherCourseDTO {
    private long id;

    private String teacherName;
    private String courseName;

    private DayTime dayTime;

    public TeacherCourseDTO(){

    }

    public TeacherCourseDTO(TeacherCourse teacherCourse) {
        this.teacherName = teacherCourse.getTeacher().getFirstName() + " " + teacherCourse.getTeacher().getLastName();
        this.courseName = teacherCourse.getCourse().getCourseName();
        this.dayTime = teacherCourse.getDayTime();
    }

    public long getId() {
        return id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getCourseName() {
        return courseName;
    }

    public DayTime getDayTime() {
        return dayTime;
    }
}
