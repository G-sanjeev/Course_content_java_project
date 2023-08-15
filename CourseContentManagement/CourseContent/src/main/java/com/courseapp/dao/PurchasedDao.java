package com.courseapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.courseapp.model.Course;
import com.courseapp.model.PurchasedData;
import com.courseapp.util.DBConnection;
import com.courseapp.util.Queries;

public class PurchasedDao implements IPurchased{

	@Override
	public List<PurchasedData> findAll() {
		List<PurchasedData> purchasedList = new ArrayList<PurchasedData>();
		try (Connection connection = DBConnection.openConnection(); // get connection
				PreparedStatement statement = connection.prepareStatement(Queries.SHOWALLQUERY);
				ResultSet resultSet = statement.executeQuery();) {
			while (resultSet.next()) {
//				int purchasedId = resultSet.getInt("purchasedId");
				String courseName = resultSet.getString("courseName");
				int courseId = resultSet.getInt("courseId");
				String studentName = resultSet.getString("studentName");
				int studentId = resultSet.getInt("studentId");
				List purchasedData = new ArrayList<>();
				purchasedList.add(new PurchasedData(studentId,studentName,courseId,courseName));
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return purchasedList;
	}

	@Override
	public void addPurchased(PurchasedData purchasedData) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.INSERTSTUDENTPURCHASEQUERY);) {
			statement.setString(4, purchasedData.getCourseName());
			statement.setInt(3, purchasedData.getCourseId());
			statement.setString(2, purchasedData.getStudentName());
			statement.setInt(1, purchasedData.getStudentId());
			statement.execute();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}

}
