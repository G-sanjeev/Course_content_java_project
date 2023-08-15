package com.courseapp.dao;

import java.util.List;

import com.courseapp.exceptions.CourseNotFoundException;
import com.courseapp.exceptions.StudentNotFoundException;
import com.courseapp.model.Course;
import com.courseapp.model.StudentData;

public interface IStudentDao {
	void addStudent(StudentData student);
	boolean validateStudent(String studentEmail,String studentPassword) throws StudentNotFoundException;
	List<Course> findAll();

	Course findByCourseId(int courseId) throws CourseNotFoundException;

	List<Course> findByCourseName(String courseName) throws CourseNotFoundException;

	List<Course> findByCourseCategory(String courseCategory) throws CourseNotFoundException;

	List<Course> findByPriceLessThan(double price) throws CourseNotFoundException;
	List<Course> findByCourseLevel(String courseLevel) throws CourseNotFoundException;
}
