package com.demo.service;

import com.demo.dao.CourseDaoJdbc;  // Update the import statement to use CourseDaoJdbc
import com.demo.model1.Course;

import java.sql.SQLException;
import java.util.List;

public class CourseService {
    CourseDaoJdbc courseDao = new CourseDaoJdbc();  // Update to use CourseDaoJdbc

    public void createCourse(Course course) throws SQLException {
        courseDao.createCourse(course);
    }

    public void updateCourse(Course course) throws SQLException {
        courseDao.updateCourse(course);
    }

    public void deleteCourse(int courseId) throws SQLException {
        courseDao.deleteCourse(courseId);
    }

    public List<Course> getAllCourses() throws SQLException {
        return courseDao.getAllCourses();
    }
}
