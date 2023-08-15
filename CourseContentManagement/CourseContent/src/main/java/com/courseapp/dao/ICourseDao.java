package com.courseapp.dao;

import java.util.List;

import com.courseapp.exceptions.CourseNotFoundException;
import com.courseapp.model.Course;

public interface ICourseDao {
	void addCourse(Course course);

	void updateCoursePrice(int courseId, double price);

	void updateCourseDuration(int courseId, String duration);

	void deleteCourse(int courseId);

	List<Course> findAll();

	Course findByCourseId(int courseId) throws CourseNotFoundException;

	List<Course> findByCourseName(String courseName) throws CourseNotFoundException;

	List<Course> findByCourseCategory(String courseCategory) throws CourseNotFoundException;

	List<Course> findByPriceLessThan(double price) throws CourseNotFoundException;
	List<Course> findByCourseLevel(String courseLevel) throws CourseNotFoundException;
}
