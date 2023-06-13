package com.example.springboot.jpahibernate.course.jdbc;

import com.example.springboot.jpahibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository// que habla con la bd
public class CourseJdbcRepository {
    private final JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY= """
        insert into course(id, name, author)
        values(?,?,? )
    """;

    private static String DELETE_QUERY= """
        DELETE FROM course where id=?
    """;

    private static String SELECT_QUERY= """
        SELECT * FROM course where id=?
    """;

    public CourseJdbcRepository(JdbcTemplate springJdbcTemplate) {
        this.springJdbcTemplate = springJdbcTemplate;
    }

    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void delete(long i) {
        springJdbcTemplate.update(DELETE_QUERY,i);
    }

    public Course findById(long i) {

        return springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),i);
    }
}
