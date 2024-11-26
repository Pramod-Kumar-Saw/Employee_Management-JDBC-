package com.jdbc6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Batch_Excecution {
	private static Connection con;
	private static String url = "jdbc:mysql://localhost:3306/server_1";
	private static String user = "root";
	private static String password = "root";

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			String query = "insert into Teacher values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 1);
			ps.setString(2, "Pramod");
			ps.setString(3, "24");
			ps.setString(4, "JDBC");
			ps.addBatch();
			
			ps.setInt(1, 2);
			ps.setString(2, "Subha");
			ps.setString(3, "29");
			ps.setString(4, "Physics");
			ps.addBatch();
			
			ps.setInt(1, 3);
			ps.setString(2, "Rohit");
			ps.setString(3, "31");
			ps.setString(4, "Python");
			ps.addBatch();
			
			ps.setInt(1, 4);
			ps.setString(2, "kumar");
			ps.setString(3, "26");
			ps.setString(4, "Spring");
			ps.addBatch();
			
			ps.setInt(1, 5);
			ps.setString(2, "Srikant");
			ps.setString(3, "19");
			ps.setString(4, "C++");
			ps.addBatch();
			
			ps.setInt(1, 6);
			ps.setString(2, "Pinky");
			ps.setString(3, "64");
			ps.setString(4, "Devops");
			ps.addBatch();
			ps.executeBatch();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException | NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
