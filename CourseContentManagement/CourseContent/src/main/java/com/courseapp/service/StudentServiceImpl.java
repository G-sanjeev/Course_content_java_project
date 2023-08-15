package com.courseapp.service;

import java.util.List;

import com.courseapp.dao.CourseDaoImpl;
import com.courseapp.dao.ICourseDao;
import com.courseapp.dao.IStudentDao;
import com.courseapp.dao.StudentDao;
import com.courseapp.exceptions.CourseNotFoundException;
import com.courseapp.exceptions.StudentNotFoundException;
import com.courseapp.model.Course;
import com.courseapp.model.StudentData;

public class StudentServiceImpl implements IStudentService{
	ICourseDao courseDao = new CourseDaoImpl();
	IStudentDao studentDao = new StudentDao();
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
		@Override
		public void addStudent(StudentData student) {
			try {
				studentDao.addStudent(student);
			} catch (Exception e) {
e.printStackTrace();			}
			
		}
		@Override
		public boolean validateStudent(String studentEmail, String studentPassword) throws StudentNotFoundException {
			if(studentDao.validateStudent(studentEmail, studentPassword)) {
				return true;
			}
			return false;
		}


}
