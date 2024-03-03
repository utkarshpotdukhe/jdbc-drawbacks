package com.demo.dao;

import com.demo.model1.Course;
import com.demo.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CourseDaoJdbc {

    public void createCourse(Course course) throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        String query = "INSERT INTO courses(courseId, courseName, coursePrice) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, course.getCourseId());
            preparedStatement.setString(2, course.getCourseName());
            preparedStatement.setInt(3, course.getCoursePrice());
            preparedStatement.executeUpdate();
            System.out.println("Course created");
        }
    }

    public void updateCourse(Course course) throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        String query = "UPDATE courses SET courseName=?, coursePrice=? WHERE courseId=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setInt(2, course.getCoursePrice());
            preparedStatement.setInt(3, course.getCourseId());
            preparedStatement.executeUpdate();
            System.out.println("Course updated");
        }
    }

    public void deleteCourse(int courseId) throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        String query = "DELETE FROM courses WHERE courseId=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, courseId);
            preparedStatement.executeUpdate();
            System.out.println("Course deleted");
        }
    }

    public List<Course> getAllCourses() throws SQLException {
        List<Course> courseList = new ArrayList<>();
        Connection connection = ConnectionUtil.getConnection();
        String query = "SELECT * FROM courses";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseId(resultSet.getInt("courseId"));
                course.setCourseName(resultSet.getString("courseName"));
                course.setCoursePrice(resultSet.getInt("coursePrice"));
                courseList.add(course);
            }
        }
        return courseList;
    }
}
