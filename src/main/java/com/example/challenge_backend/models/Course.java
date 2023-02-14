package com.example.challenge_backend.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String courseName;
    private DayTime dayTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private Set<Student> students = new HashSet<>();

    public Course() {
    }

    public Course(String courseName, DayTime dayTime) {
        this.courseName = courseName;
        this.dayTime = dayTime;
    }

    public Course(String courseName, DayTime dayTime, Teacher teacher) {
        this.courseName = courseName;
        this.dayTime = dayTime;
        this.teacher = teacher;
    }

    public Course(String courseName, DayTime dayTime, Teacher teacher, Set<Student> students) {
        this.courseName = courseName;
        this.dayTime = dayTime;
        this.teacher = teacher;
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public DayTime getDayTime() {
        return dayTime;
    }

    public void setDayTime(DayTime dayTime) {
        this.dayTime = dayTime;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
