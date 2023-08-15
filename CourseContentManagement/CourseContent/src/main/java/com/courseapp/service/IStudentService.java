package com.courseapp.service;

import java.util.List;

import com.courseapp.exceptions.CourseNotFoundException;
import com.courseapp.exceptions.StudentNotFoundException;
import com.courseapp.model.Course;
import com.courseapp.model.StudentData;

public interface IStudentService {
	void addStudent(StudentData student);
	boolean validateStudent(String studentEmail,String studentPassword) throws StudentNotFoundException;
	List<Course> getAll();
	Course getByCourseId(int courseId) throws CourseNotFoundException;
	List<Course> getByCourseName(String courseName) throws CourseNotFoundException;
	List<Course> getByCourseCategory(String courseCategory) throws CourseNotFoundException;
	List<Course> getByPriceLessThan(double price) throws CourseNotFoundException;
	List<Course> getByCourseLevel(String courseLevel) throws CourseNotFoundException;

	
	
}
