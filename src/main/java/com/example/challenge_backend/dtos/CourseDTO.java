package com.example.challenge_backend.dtos;

import com.example.challenge_backend.models.Course;
import com.example.challenge_backend.models.DayTime;

public class CourseDTO {
    private long id;
    private  String courseName;
    private DayTime dayTime;

    public CourseDTO() {
    }

    public CourseDTO(Course courses) {
        this.id = courses.getId();
        this.courseName = courses.getCourseName();
        this.dayTime = courses.getDayTime();
    }

    public long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public DayTime getDayTime() {
        return dayTime;
    }

}
