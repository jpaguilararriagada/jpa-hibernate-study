package com.example.springboot.jpahibernate.course.springdatajpa;

import com.example.springboot.jpahibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course,Long> {

}
