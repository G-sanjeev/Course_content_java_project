package com.courseapp.model;

public class Course implements Comparable<Course>{
	private String courseName;
	private Integer courseId;
	private String courseCategory;
	private String courseLanguage;
	private String courseDuration;
	private double price;
	private String level;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Course(String courseName, Integer courseId, String courseCategory, String courseLanguage,
			String courseDuration, double price, String level) {
		super();
		this.courseName = courseName;
		this.courseId = courseId;
		this.courseCategory = courseCategory;
		this.courseLanguage = courseLanguage;
		this.courseDuration = courseDuration;
		this.price = price;
		this.level = level;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public Integer getCourseId() {
		return courseId;
	}


	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}


	public String getCourseCategory() {
		return courseCategory;
	}


	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}


	public String getCourseLanguage() {
		return courseLanguage;
	}


	public void setCourseLanguage(String courseLanguage) {
		this.courseLanguage = courseLanguage;
	}


	public String getCourseDuration() {
		return courseDuration;
	}


	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseId=" + courseId + ", courseCategory=" + courseCategory
				+ ", courseLanguage=" + courseLanguage + ", courseDuration=" + courseDuration + ", price=" + price
				+ ", level=" + level + "]";
	}


	@Override
	public int compareTo(Course o) {
return this.courseId.compareTo(o.courseId);	}
	
	
	

}
