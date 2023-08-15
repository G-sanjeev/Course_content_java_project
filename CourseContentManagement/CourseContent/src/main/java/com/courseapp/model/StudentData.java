package com.courseapp.model;

public class StudentData implements Comparable<StudentData>{
	String studentName;
	String studentEmail;
	int studentAge;
	String studentGender;
	String studentPassword;
	public StudentData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentData(String studentName, String studentEmail, int studentAge, String studentGender,
			String studentPassword) {
		super();
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentAge = studentAge;
		this.studentGender = studentGender;
		this.studentPassword = studentPassword;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	public String getStudentGender() {
		return studentGender;
	}
	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	@Override
	public String toString() {
		return "StudentData [studentName=" + studentName + ", studentEmail=" + studentEmail + ", studentAge="
				+ studentAge + ", studentGender=" + studentGender + ", studentPassword=" + studentPassword + "]";
	}
	@Override
	public int compareTo(StudentData o) {
		return this.studentEmail.compareTo(o.studentEmail);
	}
	
	



	
	

}
