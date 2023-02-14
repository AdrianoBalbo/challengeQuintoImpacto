package com.example.challenge_backend;

import com.example.challenge_backend.dtos.CourseDTO;
import com.example.challenge_backend.models.*;
import com.example.challenge_backend.repositories.CourseRepository;
import com.example.challenge_backend.repositories.StudentRepository;
import com.example.challenge_backend.repositories.TeacherCourseRepository;
import com.example.challenge_backend.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ChallengeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeBackendApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(StudentRepository studentRepository, CourseRepository courseRepository, TeacherRepository teacherRepository, TeacherCourseRepository teacherCourseRepository){

		return (args)-> {


			//COURSES
			Course course1 = new Course("Course 1", DayTime.MORNING);
			Course course2 = new Course("Course 2", DayTime.AFTERNOON);
			Course course3 = new Course("Course 3", DayTime.NIGHT);
			Course course4 = new Course("Course 4", DayTime.MORNING);
			Course course5 = new Course("Course 5", DayTime.AFTERNOON);
			Course course6 = new Course("Course 6", DayTime.NIGHT);
			Course course7 = new Course("Course 7", DayTime.MORNING);
			Course course8 = new Course("Course 8", DayTime.AFTERNOON);
			Course course9 = new Course("Course 9", DayTime.NIGHT);

			Set<Course> courses = new HashSet<>();
			courses.add(course1);
			courses.add(course2);


			//STUDENTS
			Student florSandoval = new Student("Flor", "Sandoval", "florsandoval@gmail.com", courses);
			Student juanPerez = new Student("Juan", "Perez", "juanperez@gmail.com", courses);
			Student arielTorres = new Student("Ariel", "Torres", "aritorres@gmail.com", courses);
			Student pedroRoca = new Student("Pedro", "Roca", "pedroroca@gmail.com", courses);

			//TEACHERS
			Teacher seymourSkinner = new Teacher("Seymour", "Skinner", "seymourskinner@gmail.com",passwordEncoder.encode("123"));
			Teacher ednaKrabappel = new Teacher("Edna", "Krabappel", "ednak@gmail.com",passwordEncoder.encode("123"));
			Teacher elizabethHoover = new Teacher("Elizabeth", "Hoover", "ehoover@gmail.com",passwordEncoder.encode("123"));
			Teacher admin = new Teacher("Admin","Istrador", "admin@quintoimpactoadmin.com", passwordEncoder.encode("123"));

			TeacherCourse teacherCourse1 = new TeacherCourse(seymourSkinner, course1);
			TeacherCourse teacherCourse2 = new TeacherCourse(ednaKrabappel, course2);
			TeacherCourse teacherCourse3 = new TeacherCourse(elizabethHoover, course3);
			TeacherCourse teacherCourse4 = new TeacherCourse(seymourSkinner, course6);

			courseRepository.save(course1);
			courseRepository.save(course2);
			courseRepository.save(course3);
			courseRepository.save(course6);

			studentRepository.save(florSandoval);
			studentRepository.save(juanPerez);
			studentRepository.save(arielTorres);
			studentRepository.save(pedroRoca);

			teacherRepository.save(seymourSkinner);
			teacherRepository.save(ednaKrabappel);
			teacherRepository.save(elizabethHoover);
			teacherRepository.save(admin);

			teacherCourseRepository.save(teacherCourse1);
			teacherCourseRepository.save(teacherCourse2);
			teacherCourseRepository.save(teacherCourse3);
			teacherCourseRepository.save(teacherCourse4);


		};

	}
	@Autowired
	private PasswordEncoder passwordEncoder;

}
