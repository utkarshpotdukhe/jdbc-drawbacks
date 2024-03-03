package com.demo;

import com.demo.controller.CourseController;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        CourseController courseController = new CourseController();
        courseController.getAllCourses().forEach(System.out::println);
    }
}
