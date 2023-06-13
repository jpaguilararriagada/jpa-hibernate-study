package com.example.springboot.jpahibernate.course;

import com.example.springboot.jpahibernate.course.Course;
import com.example.springboot.jpahibernate.course.jdbc.CourseJdbcRepository;
import com.example.springboot.jpahibernate.course.jpa.CourseJpaRepository;
import com.example.springboot.jpahibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    //private final CourseJpaRepository repository;

    private final CourseSpringDataJpaRepository repository;

    public CourseCommandLineRunner( CourseSpringDataJpaRepository repository) {
        //this.repository = repository;
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1,"test","test"));
        repository.save(new Course(2,"test2","test2"));
        repository.deleteById(1l);
        System.out.println(repository.findById(2l));

    }
}
