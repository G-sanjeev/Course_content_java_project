package com.courseapp.service;

import java.util.List;

import com.courseapp.dao.CourseDaoImpl;
import com.courseapp.dao.ICourseDao;
import com.courseapp.exceptions.CourseNotFoundException;
import com.courseapp.model.Course;

public class CouseServiceImpl implements ICourseService {
	ICourseDao courseDao = new CourseDaoImpl();

	// inserting the details into course using :insert query
	@Override
	public void addCourse(Course course) {
		try {
			courseDao.addCourse(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//updating the value of price: update price
	@Override
	public void updateCoursePrice(int courseId, double price) {
		try {
			courseDao.updateCoursePrice(courseId, price);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//updating the value of duration: update duration
	@Override
	public void updateCourseDuration(int courseId, String duration) {
		try {
			courseDao.updateCourseDuration(courseId, duration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//deleting the course by course id: delete course
	@Override
	public void deleteCourse(int courseId) {
		try {
			courseDao.deleteCourse(courseId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
// printing all the details: get query
	@Override
	public List<Course> getAll() {
		return courseDao.findAll();
	}
//printing all the details by course id: get by id query
	@Override
	public Course getByCourseId(int courseId) throws CourseNotFoundException {
		Course course = courseDao.findByCourseId(courseId);
		if (course == null) {
			throw new CourseNotFoundException("course not found by the id");
		}
		return course;
	}
// printing the details by course name; get by course name
	@Override
	public List<Course> getByCourseName(String courseName) throws CourseNotFoundException {
		List<Course> courses = courseDao.findByCourseName(courseName);
		if (courses.isEmpty()) {
			throw new CourseNotFoundException("course not found by the id");

		}
		return courses.stream().sorted((x, y) -> x.compareTo(y)).toList();
	}
//printing the details by course category; get by course category 
	@Override
	public List<Course> getByCourseCategory(String courseCategory) throws CourseNotFoundException {
		List<Course> courses = courseDao.findByCourseCategory(courseCategory);
		if (courses.isEmpty()) {
			throw new CourseNotFoundException("course not found by the id");

		}
		return courses.stream().sorted((x, y) -> x.compareTo(y)).toList();
	}
// printing the details by price less than: get by course price less than 
	@Override
	public List<Course> getByPriceLessThan(double price) throws CourseNotFoundException {
		List<Course> courses = courseDao.findByPriceLessThan(price);
		if (courses.isEmpty()) {
			throw new CourseNotFoundException("course not found by the id");

		}
		return courses.stream().sorted((x, y) -> x.compareTo(y)).toList();
	}

	@Override
	public List<Course> getByCourseLevel(String courseLevel) throws CourseNotFoundException {
		List<Course> courses = courseDao.findByCourseLevel(courseLevel);
		if (courses.isEmpty()) {
			throw new CourseNotFoundException("course not found by the id");

		}
		return courses.stream().sorted((x, y) -> x.compareTo(y)).toList();
	}

	

}
