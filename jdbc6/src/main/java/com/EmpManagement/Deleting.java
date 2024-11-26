package com.EmpManagement;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deleting {
	public static void delete() {
		System.out.println("--> For delete the row <--");
		System.out.println("Enter the id");
		int id = EmployeeMain.sc.nextInt();
		String query = "delete from employee02 where id =?";

		try {
			PreparedStatement ps = EmployeeMain.con.prepareStatement(query);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Delete row Successfully\n");
			} else {
				System.out.println("Not Deleted\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
