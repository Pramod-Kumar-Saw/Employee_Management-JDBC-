package com.EmpManagement;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Updating {
	public static void update() {
		System.out.println("--> For Update the data <--");
		System.out.println("For update the Name, press - 1" + "\n" + "For update the Age, press - 2" + "\n"
				+ "For update the salary, press - 3");
		int num = EmployeeMain.sc.nextInt();
		switch (num) {
		case 1:
			System.out.println("\nEnter Name");
			String name = EmployeeMain.sc.next();
			System.out.println("Enter id");
			int id1 = EmployeeMain.sc.nextInt();
//			System.out.println("Enter the name you wish to update");
			String query1 = "update employee02 set name = ? where id = ?";
			try {
				PreparedStatement ps = EmployeeMain.con.prepareStatement(query1);
				ps.setString(1, name);
				ps.setInt(2, id1);
				int i = ps.executeUpdate();
				if (i > 0) {
					System.out.println("update Successfully\n");
				} else {
					System.out.println("Not Upadated\n");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 2:
			System.out.println("Enter Age");
			int age = EmployeeMain.sc.nextInt();
			System.out.println("Enter id");
			int id2 = EmployeeMain.sc.nextInt();
			String query2 = "update employee02 set age = ? where id = ?";
			try {
				PreparedStatement ps = EmployeeMain.con.prepareStatement(query2);
				ps.setInt(1, age);
				ps.setInt(2, id2);
				int i = ps.executeUpdate();
				if (i > 0) {
					System.out.println("update Successfully\n");
				} else {
					System.out.println("Not Upadated\n");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			System.out.println("Enter Salary");
			double sal = EmployeeMain.sc.nextDouble();
			System.out.println("Enter id");
			int id3 = EmployeeMain.sc.nextInt();
			String query3 = "update employee02 set sal = ? where id = ?";
			try {
				PreparedStatement ps = EmployeeMain.con.prepareStatement(query3);
				ps.setDouble(1, sal);
				ps.setInt(2, id3);
				int i = ps.executeUpdate();
				if (i > 0) {
					System.out.println("update Successfully\n");
				} else {
					System.out.println("Not Upadated\n");
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
