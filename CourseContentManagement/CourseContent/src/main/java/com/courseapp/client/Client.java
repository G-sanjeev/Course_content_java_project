package com.courseapp.client;

import java.util.List;
import java.util.Scanner;

import com.courseapp.model.Course;
import com.courseapp.model.PurchasedData;
import com.courseapp.model.StudentData;
import com.courseapp.service.CouseServiceImpl;
import com.courseapp.service.ICourseService;
import com.courseapp.service.IPurchaseService;
import com.courseapp.service.IStudentService;
import com.courseapp.service.PurchasedService;
import com.courseapp.service.StudentServiceImpl;

public class Client {

	public static void main(String[] args) {
		
		String courseName;
		int courseId;
		String courseCategory;
		String courseLanguage;
		String courseDuration;
		double price;
		String courseLevel;
		
		
		String studentName;
		int studentId;
		String studentEmail;
		int studentAge;
		String studentGender;
		String studentPassword;
		System.out.println("Welcome to concour:");
		System.out.println("***************************************************************");
		System.out.println("1.Student");
		System.out.println("2.Admin");
		System.out.println("enter option to login");
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		if(option == 1) {
			System.out.println("student");
			IPurchaseService purchaseService = new PurchasedService();

			ICourseService courseService = new CouseServiceImpl();

			IStudentService studentService = new StudentServiceImpl();
			System.out.println("Enter 1: login");
			System.out.println("Enter 2: Register");
			System.out.println("enter choice");
			int choice = scanner.nextInt();
			if(choice == 1) {
				System.out.println("enter the Email:");
				scanner.nextLine();
				String email = scanner.nextLine();
				System.out.println("enter the password:");
				String password = scanner.nextLine();
				
				if(studentService.validateStudent(email, password)) {
					try {
						while (true) {
							System.out.println("enter the choice:\n"+ "1.findAll\n" + "2.findByCourseId\n"
									+ "3.findByCourseName\n" + "4.findByCourseCategory\n" + "5.findByPriceLessThan\n" + "6. find by course level \n"+"7.Purchase course\n"+"8.exit");

							int choice1 = scanner.nextInt();
							scanner.nextLine();
							switch (choice1) {
							
							case 1:
								List<Course> course = courseService.getAll();
								System.out.println("the list of courses available are:");
								course.forEach(System.out::println);

								break;
							case 2:
								System.out.print("enter the course id: ");
								courseId = scanner.nextInt();
								
								System.out.println(courseService.getByCourseId(courseId));
								break;
							case 3:
								System.out.print("enter the course name: ");
								courseName = scanner.nextLine();
								courseService.getByCourseName(courseName).forEach(System.out::println);
								System.out.println();
								break;
							case 4:
								System.out.print("enter the course category: ");
								courseCategory = scanner.nextLine();
								courseService.getByCourseCategory(courseCategory).forEach(System.out::println);
								System.out.println();
								break;
							case 5:
								System.out.print("enter the course price: ");
								price = scanner.nextDouble();
								courseService.getByPriceLessThan(price).forEach(System.out::println);
								System.out.println();
								break;
							case 6:
								System.out.print("enter the course Level:");
								courseLevel = scanner.nextLine();
								courseService.getByCourseLevel(courseLevel).forEach(System.out::println);
								break;
							case 7:
								System.out.println("enter details to purchase course:");
								System.out.println("enter the your name");
								studentName = scanner.nextLine();
								System.out.println("enter course name");
								courseName = scanner.nextLine();
								System.out.println("enter the student Id");
								studentId = scanner.nextInt();
								System.out.println("enter the courseId");
								courseId = scanner.nextInt();
								purchaseService.addPurchased(new PurchasedData(studentId,studentName,courseId,courseName));
								System.out.println("successfully added");
								break;
							case 8:
								System.exit(8);
							default:
								break;

							}
						}

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						scanner.close();
					}
				}
				else {
					System.out.println("enter the valid credentials");
				}
				
				
				
				
			}
			else if(choice == 2) {
				System.out.println("enter email");
				scanner.nextLine();
				studentEmail = scanner.nextLine();
				System.out.println("enter name:");
				
				studentName = scanner.nextLine();
				System.out.println("enter gender");
				studentGender = scanner.nextLine();
				System.out.println("enter password");
				studentPassword = scanner.nextLine();
				System.out.println("enter age");
				studentAge = scanner.nextInt();
				studentService.addStudent( new StudentData(studentName,studentEmail,studentAge,studentGender,studentPassword));
				System.out.println("Registration occured successfully ");
			}
			else {
				System.out.println("enter the valid choice");
			}
			
		}else if(option == 2) {
			System.out.println("Admin");
			
			ICourseService courseService = new CouseServiceImpl();
			IPurchaseService purchaseService = new PurchasedService();
			
			try {
				while (true) {
					System.out.println("enter the choice:\n" + "1.addCourse\n" + "2.updateCoursePrice\n"
							+ "3.updateCourseDuration\n" + "4.deleteCourse\n" + "5.findAll\n" + "6.findByCourseId\n"
							+ "7.findByCourseName\n" + "8.findByCourseCategory\n" + "9.findByPriceLessThan\n" + "10. find by course level \n"+"11.exit");

					int choice = scanner.nextInt();
					scanner.nextLine();
					switch (choice) {
					case 1:
						System.out.println("enter the course name:");
						courseName = scanner.nextLine();
						System.out.println("enter the course category");
						courseCategory = scanner.nextLine();
						System.out.println("enter the courseLanguage");
						courseLanguage = scanner.nextLine();
						System.out.println("enter the courseDuration");
						courseDuration = scanner.nextLine();
						System.out.println("enter the course level:");
						courseLevel = scanner.nextLine();
						System.out.println("enter the course id");
						courseId = scanner.nextInt();
						System.out.println("enter the price");
						price = scanner.nextDouble();
						courseService.addCourse(
								new Course(courseName, courseId, courseCategory, courseLanguage, courseDuration, price,courseLevel));
						break;
					case 2:
						System.out.print("enter the courseId: ");
						courseId = scanner.nextInt();
						System.out.print("enter the price:");
						price = scanner.nextDouble();
						
						courseService.updateCoursePrice(courseId, price);
						System.out.println();
						break;
					case 3:
						
						
						System.out.print("enter the duration: ");
						courseDuration = scanner.nextLine();
						System.out.print("enter the courseId: ");
						courseId = scanner.nextInt();
						courseService.updateCourseDuration(courseId, courseDuration);
						System.out.println();
						break;
					case 4:
						System.out.print("enter the course id: ");
						courseId = scanner.nextInt();
						courseService.deleteCourse(courseId);
						System.out.println();
						break;

					case 5:
						List<Course> course = courseService.getAll();
						System.out.println("the list of courses available are:");
						course.forEach(System.out::println);

						break;
					case 6:
						System.out.print("enter the course id: ");
						courseId = scanner.nextInt();
						
						System.out.println(courseService.getByCourseId(courseId));
						break;
					case 7:
						System.out.print("enter the course name: ");
						courseName = scanner.nextLine();
						courseService.getByCourseName(courseName).forEach(System.out::println);
						System.out.println();
						break;
					case 8:
						System.out.print("enter the course category: ");
						courseCategory = scanner.nextLine();
						courseService.getByCourseCategory(courseCategory).forEach(System.out::println);
						System.out.println();
						break;
					case 9:
						System.out.print("enter the course price: ");
						price = scanner.nextDouble();
						courseService.getByPriceLessThan(price).forEach(System.out::println);
						System.out.println();
						break;
					case 10:
						System.out.print("enter the course Level:");
						courseLevel = scanner.nextLine();
						courseService.getByCourseLevel(courseLevel).forEach(System.out::println);
					case 11:
						List<PurchasedData> purchasedDatas = purchaseService.getAll();
						System.out.println("the list of courses available are:");
						purchasedDatas.forEach(System.out::println);

						break;
					case 12:
						System.exit(12);
					default:
						break;

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				scanner.close();
			}

			
		}
		else {
			System.out.println("enter proper value");
		}
		
	}
}
