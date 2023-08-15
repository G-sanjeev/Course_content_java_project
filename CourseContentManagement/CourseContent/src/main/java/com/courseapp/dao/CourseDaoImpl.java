package com.courseapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.courseapp.exceptions.CourseNotFoundException;
import com.courseapp.model.Course;
import com.courseapp.util.DBConnection;
import com.courseapp.util.Queries;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public void addCourse(Course course) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY);) {
			statement.setString(1, course.getCourseName());
			statement.setInt(2, course.getCourseId());
			statement.setString(3, course.getCourseCategory());
			statement.setString(4, course.getCourseLanguage());
			statement.setString(5, course.getCourseDuration());
			statement.setDouble(6, course.getPrice());
			statement.setString(7, course.getLevel());
			statement.execute();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void updateCoursePrice(int courseId, double price) {
try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.UPDATEQUERYPRICE);){
	statement.setInt(2, courseId);
	statement.setDouble(1, price);
	statement.execute();
	
} catch (Exception e) {
e.printStackTrace();}
	}

	@Override
	public void updateCourseDuration(int courseId, String duration) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.UPDATEQUERYDURATION);){
	statement.setInt(2, courseId);
	statement.setString(1, duration);
	statement.execute();
	
} catch (Exception e) {
e.printStackTrace();}
	}

	@Override
	public void deleteCourse(int courseId) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);){
	statement.setInt(1, courseId);
	statement.execute();
	
} catch (Exception e) {
e.printStackTrace();}
	}

	@Override
	public List<Course> findAll() {
		List<Course> courseList = new ArrayList<Course>();
		try (Connection connection = DBConnection.openConnection(); // get connection
				// create a prepared statement
				PreparedStatement statement = connection.prepareStatement(Queries.GETQUERY);
				ResultSet resultSet = statement.executeQuery();) {
			while (resultSet.next()) {
				String name = resultSet.getString("courseName");
				int courseId = resultSet.getInt("courseId");
				String category = resultSet.getString("courseCategory");
				String language = resultSet.getString("courseLanguage");
				String duration = resultSet.getString("duration");
				double price = resultSet.getDouble("price");
				String courseLevel1 = resultSet.getString("courseLevel");
				courseList.add(new Course(name, courseId, category, language, duration, price,courseLevel1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public Course findByCourseId(int courseId) throws CourseNotFoundException {
		Course courseList = new Course();
		try {Connection connection = DBConnection.openConnection(); // get connection
				// create a prepared statement
				PreparedStatement statement = connection.prepareStatement(Queries.GETBYIDQUERY);
				statement.setInt(1, courseId);
				ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				String name = resultSet.getString("courseName");
				int courseId1 = resultSet.getInt("courseId");
				String category = resultSet.getString("courseCategory");
				String language = resultSet.getString("courseLanguage");
				String duration = resultSet.getString("duration");
				double price = resultSet.getDouble("price");String courseLevel1 = resultSet.getString("courseLevel");
				courseList=(new Course(name, courseId1, category, language, duration, price,courseLevel1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public List<Course> findByCourseName(String courseName) throws CourseNotFoundException {
		List<Course> courseList = new ArrayList<Course>();
		try {Connection connection = DBConnection.openConnection(); // get connection
				// create a prepared statement
				PreparedStatement statement = connection.prepareStatement(Queries.GETBYCOURSENAMEQUERY);
				statement.setString(1, "%"+ courseName+"%");
				ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				String name = resultSet.getString("courseName");
				int courseId1 = resultSet.getInt("courseId");
				String category = resultSet.getString("courseCategory");
				String language = resultSet.getString("courseLanguage");
				String duration = resultSet.getString("duration");
				double price = resultSet.getDouble("price");
				String courseLevel1 = resultSet.getString("courseLevel");
				courseList.add(new Course(name, courseId1, category, language, duration, price,courseLevel1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public List<Course> findByCourseCategory(String courseCategory) throws CourseNotFoundException {
		List<Course> courseList = new ArrayList<Course>();
		try {Connection connection = DBConnection.openConnection(); // get connection
				// create a prepared statement
				PreparedStatement statement = connection.prepareStatement(Queries.GETBYCOURSECATEGORYQUERY);
				statement.setString(1,"%"+ courseCategory+"%");
				ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				String name = resultSet.getString("courseName");
				int courseId1 = resultSet.getInt("courseId");
				String category = resultSet.getString("courseCategory");
				String language = resultSet.getString("courseLanguage");
				String duration = resultSet.getString("duration");
				double price = resultSet.getDouble("price");
				String courseLevel1 = resultSet.getString("courseLevel");
				courseList.add(new Course(name, courseId1, category, language, duration, price,courseLevel1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public List<Course> findByPriceLessThan(double price) throws CourseNotFoundException {
		List<Course> courseList = new ArrayList<Course>();
		try {Connection connection = DBConnection.openConnection(); // get connection
				// create a prepared statement
				PreparedStatement statement = connection.prepareStatement(Queries.GETBYPRICELESSQUERY);
				statement.setDouble(1, price);
				ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				String name = resultSet.getString("courseName");
				int courseId1 = resultSet.getInt("courseId");
				String category = resultSet.getString("courseCategory");
				String language = resultSet.getString("courseLanguage");
				String duration = resultSet.getString("duration");
				double price1 = resultSet.getDouble("price");
				String courseLevel1 = resultSet.getString("courseLevel");
				courseList.add(new Course(name, courseId1, category, language, duration, price1,courseLevel1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public List<Course> findByCourseLevel(String courseLevel) throws CourseNotFoundException {
		List<Course> courseList = new ArrayList<Course>();
		try {Connection connection = DBConnection.openConnection(); // get connection
				// create a prepared statement
				PreparedStatement statement = connection.prepareStatement(Queries.GETBYCOURSELEVELQUERY);
				statement.setString(1, "%"+courseLevel+"%");
				ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				String name = resultSet.getString("courseName");
				int courseId1 = resultSet.getInt("courseId");
				String category = resultSet.getString("courseCategory");
				String language = resultSet.getString("courseLanguage");
				String duration = resultSet.getString("duration");
				double price1 = resultSet.getDouble("price");
				String courseLevel1 = resultSet.getString("courseLevel");
				courseList.add(new Course(name, courseId1, category, language, duration, price1,courseLevel1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseList;
	}

}
