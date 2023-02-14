package com.example.challenge_backend.configurations;

import com.example.challenge_backend.models.Student;
import com.example.challenge_backend.models.Teacher;
import com.example.challenge_backend.repositories.StudentRepository;
import com.example.challenge_backend.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(inputEmail ->{
            Teacher teacher = teacherRepository.findByEmail(inputEmail);
            Student student = studentRepository.findByEmail(inputEmail);

            if (teacher!=null){
                if (teacher.getEmail().contains("@quintoimpactoadmin")){
                    return new User(teacher.getEmail(),teacher.getPassword(),
                    AuthorityUtils.createAuthorityList("ADMIN"));
                }else {
                    return new User(teacher.getEmail(),teacher.getPassword(),AuthorityUtils.createAuthorityList("TEACHER"));
                }
            }

            if (student!=null){
                    return new User(student.getEmail(),student.getPassword(),AuthorityUtils.createAuthorityList("STUDENT"));
            }else {
                throw new UsernameNotFoundException("Unknown user registered with: "+ inputEmail);
            }
        });
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
       return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }



}
