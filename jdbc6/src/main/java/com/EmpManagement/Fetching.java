package com.EmpManagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fetching {
	public static void fetch() {
		System.out.println("--> For fetch data <--");
		System.out.println("fetch individually, press -1");
		System.out.println("for fetch all the data , press - 2");

		int choice = EmployeeMain.sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter the id");
			int id = EmployeeMain.sc.nextInt();
			String query = "select * from employee02 where id =?";
			try {
				PreparedStatement ps = EmployeeMain.con.prepareStatement(query);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					System.out.println("\n===========================");
					System.out.println("id - " + rs.getInt("id"));
					System.out.println("name - " + rs.getString("name"));
					System.out.println("age - " + rs.getInt("age"));
					System.out.println("salary - " + rs.getDouble("sal"));
					System.out.println("=============================\n");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			String query1 = "select * from employee02";
			try {
				System.out.println("All the data");
				PreparedStatement ps = EmployeeMain.con.prepareStatement(query1);
				// ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					System.out.println("===========================");
					System.out.println("id - " + rs.getInt("id"));
					System.out.println("name - " + rs.getString("name"));
					System.out.println("age - " + rs.getInt("age"));
					System.out.println("salary - " + rs.getDouble("sal"));
					System.out.println("============================");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("Invalid Input");
		}

	}
}
