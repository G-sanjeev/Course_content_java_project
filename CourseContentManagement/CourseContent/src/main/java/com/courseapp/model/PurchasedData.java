package com.courseapp.model;

public class PurchasedData {
//	int purchasedId;
	int studentId;
	String studentName;
	int courseId;
	String courseName;
	public PurchasedData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PurchasedData(int studentId, String studentName, int courseId, String courseName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.courseId = courseId;
		this.courseName = courseName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "PurchasedData [studentId=" + studentId + ", studentName=" + studentName + ", courseId=" + courseId
				+ ", courseName=" + courseName + "]";
	}
	
	

}
