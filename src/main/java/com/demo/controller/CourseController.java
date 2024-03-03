package com.demo.controller;

import com.demo.model1.Course;
import com.demo.service.CourseService;

import java.sql.SQLException;
import java.util.List;

public class CourseController {
    private CourseService courseService;

    public CourseController() {
        this.courseService = new CourseService();
    }

    public void updateCourse(Course course) throws SQLException {
        courseService.updateCourse(course);
    }

    public void deleteCourse(int courseId) throws SQLException {
        courseService.deleteCourse(courseId);
    }

    public List<Course> getAllCourses() throws SQLException {
        return courseService.getAllCourses();
    }
}
