package com.EmpManagement;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Inserting {
	public static void add() {
		System.out.println("--> For Insert The data <--");
		System.out.println("Enter id");
		int id = EmployeeMain.sc.nextInt();
		System.out.println("Enter name");
		String name = EmployeeMain.sc.next();
		System.out.println("Enter age");
		int age = EmployeeMain.sc.nextInt();
		System.out.println("Enter salary");
		double sal = EmployeeMain.sc.nextDouble();

		String query = "insert into employee02 values(?,?,?,?)";

		try {
			PreparedStatement ps = EmployeeMain.con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setDouble(4, sal);
			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Inserted Successfully\n");
			} else {
				System.out.println(" Not Inserted\n");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
