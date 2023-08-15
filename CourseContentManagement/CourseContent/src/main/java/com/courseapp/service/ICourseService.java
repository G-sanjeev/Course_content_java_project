package com.courseapp.service;

import java.util.List;

import com.courseapp.exceptions.CourseNotFoundException;
import com.courseapp.model.Course;

public interface ICourseService {
	void addCourse(Course course);
	void updateCoursePrice(int courseId,double price);
	void updateCourseDuration(int courseId,String duration);
	void deleteCourse(int courseId);
	
	List<Course> getAll();
	Course getByCourseId(int courseId) throws CourseNotFoundException;
	List<Course> getByCourseName(String courseName) throws CourseNotFoundException;
	List<Course> getByCourseCategory(String courseCategory) throws CourseNotFoundException;
	List<Course> getByPriceLessThan(double price) throws CourseNotFoundException;
	List<Course> getByCourseLevel(String courseLevel) throws CourseNotFoundException;
	
	

}
