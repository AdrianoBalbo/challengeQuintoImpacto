package com.example.challenge_backend.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class TeacherCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private DayTime dayTime;

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    public TeacherCourse() {
    }

    public TeacherCourse(Teacher teacher, Course course) {
        this.teacher = teacher;
        this.course = course;
        this.dayTime =course.getDayTime();
    }

    public long getId() {
        return id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Course getCourse() {
        return course;
    }

    public DayTime getDayTime() {
        return dayTime;
    }
}
