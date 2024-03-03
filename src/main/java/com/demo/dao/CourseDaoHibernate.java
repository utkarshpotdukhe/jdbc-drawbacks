package com.demo.dao;

import com.demo.model1.Course;
import com.demo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class CourseDaoHibernate {

    public void createCourse(Course course) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
        }
    }

    public void updateCourse(Course course) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(course);
            transaction.commit();
        }
    }

    public void deleteCourse(int courseId) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            session.delete(course);
            transaction.commit();
        }
    }

    public List<Course> getAllCourses() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Course", Course.class).list();
        }
    }
}
