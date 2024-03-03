package com.demo;

import com.demo.dao.CourseDaoHibernate;
import com.demo.model1.Course;

import java.sql.SQLException;

public class HibernateApp {
    public static void main(String[] args) throws SQLException {
        CourseDaoHibernate courseDaoHibernate = new CourseDaoHibernate();

        // Create a new course using Hibernate
        courseDaoHibernate.createCourse(Course.builder()
                .courseName("Hibernate")
                .coursePrice(1000)
                .build());

        // Retrieve all courses and print them
        courseDaoHibernate.getAllCourses().forEach(System.out::println);
    }
}
