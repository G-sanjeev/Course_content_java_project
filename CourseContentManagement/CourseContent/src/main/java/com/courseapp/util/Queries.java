package com.courseapp.util;

public class Queries {
	//course table and related operations for the admin
	public static final String 	CREATEQUERY = "create table if not exists course (courseName varchar(20) not null,courseId int primary key,"
			+"courseCategory varchar(20) not null, courseLanguage varchar(20) not null,duration varchar(20) not null, price double not null,courseLevel varchar(20) not null)";
	public static final String  INSERTQUERY = "insert into course (courseName,courseId,courseCategory,courseLanguage,duration,price,courseLevel) values(?,?,?,?,?,?,?)";
	public static final String  UPDATEQUERYPRICE = "update course set  price =? where courseId =?";
	public static final String 	UPDATEQUERYDURATION = "update course set duration =? where courseId = ?";
	public static final String 	DELETEQUERY = "delete from course where courseId = ?";
	public static final String 	GETQUERY = "select * from course";//student
	public static final String 	GETBYIDQUERY="select * from course where courseId = ?";//student
	public static final String 	GETBYCOURSENAMEQUERY = "select * from course where courseName like ?";//student
	public static final String  GETBYCOURSECATEGORYQUERY = "select * from course where courseCategory like ?";//student
	public static final String  GETBYPRICELESSQUERY = "select * from course where price < ? ";//student
	public static final String  GETBYCOURSELEVELQUERY = "select * from course where courseLevel like ?";//student
	
	
	//student authentication :if exists login else register
	
	//Student table
	public static final String CREATESTUDENTQUERY="create table if not exists student (studentName varchar(20) not null,studentAge int not null,studentGender varchar(20) not null,"
			+"studentId Integer not null Auto_Increment primary key,studentEmail varchar(20) not null,studentPassword varchar(20) not null)";
	public static final String 	INSERTSTUDENTDETAILSQUERY = "insert into student (studentName,studentAge,studentGender,studentEmail,studentPassword) values (?,?,?,?,?)";
	public static final String VALIDATESTUDENTQUERY = "select * from student where studentEmail = ? and studentPassword=?";
	
	
	//student purchased data
	public static final String PURCHASEDQUERY = "create table if not exists purchased (purchasedId int auto_increment primary key ,studentId int ,studentName varchar(20),courseId int,courseName varchar(20))";
	public static final String INSERTSTUDENTPURCHASEQUERY="insert into purchased(studentId,studentName,courseId , courseName)"
			+ "select(select studentId from student where studentId =? limit 1) as studentId,"
			+ "(select studentName from student where studentName =? limit 1) as studentName,"
			+ "(select courseId from course where courseId = ? limit 1) as courseId,"
			+ "(select courseName from course where courseName= ? limit 1) as courseName";
	public static final String 	SHOWALLQUERY = "select * from purchased";
}