package com.EmpManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeMain {
	private static String url = "jdbc:mysql://localhost:3306/server_1";
	private static String user = "root";
	private static String password = "root";
	public static Connection con = null;
	public static Scanner sc = new Scanner(System.in);

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		System.out.println("*****WELCOME TO EMPLOYEE MANAGER TABLE*****\n");

		boolean flag = true;
		while (flag) {
			System.out.println("For Insert data , press - 1");
			System.out.println("For Update data , press - 2");
			System.out.println("For Delete data , press - 3");
			System.out.println("For Fetching data, press - 4");
			System.out.println("For Exit , press - 5\n");

			System.out.println("Enter a number");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				Inserting.add();
				break;
			case 2:
				Updating.update();
				break;
			case 3:
				Deleting.delete();
				break;
			case 4:
				Fetching.fetch();
				break;
			case 5:
				flag = false;
				System.out.println("Exit Successfully ✔️✔️");
				break;
			default:
				System.out.println("Invalid Input");
			}
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
