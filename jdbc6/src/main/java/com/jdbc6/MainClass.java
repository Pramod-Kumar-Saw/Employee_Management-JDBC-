package com.jdbc6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class InsertData {
	public static void insertData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--> For Insert Data");
		System.out.println("Enter id");
		String id = sc.next();
		System.out.println("Enter username");
		String userName = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		System.out.println("Enter Email");
		String eMail = sc.next();
		System.out.println("Enter Date Of Birth");
		String dob = sc.next();
		System.out.println("Enter Profession");
		String profession = sc.next();

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/server_1", "root", "root");
			Statement st = con.createStatement();
			String query = "insert into instagram values('" + id + "', '" + userName + "', '" + password + "', '"
					+ eMail + "', '" + dob + "', '" + profession + "')";
			int noOfRowsUpdate = st.executeUpdate(query);
			System.out.println(noOfRowsUpdate);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException | NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Updatedata {
	public static void updateData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--> For Update Data");
		System.out.println("Enter the id for update");
		String id = sc.nextLine();
		System.out.println("For update the userName, press - 1" + "\n" + "For update the password, press - 2" + "\n"
				+ "For update the email, press - 3" + "\n" + "For update the DOB, press - 4" + "\n"
				+ "For update the proffesion, press - 5");
		String input = sc.nextLine();
		int num = Integer.parseInt(input);
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/server_1", "root", "root");
			Statement st = con.createStatement();
			switch (num) {
			case 1:
				System.out.println("Enter the name you wish to update");
				String userName = sc.next();
				String query1 = "update instagram set userName = '" + userName + "' where id = '" + id + "'";
				int noOfRowsUpdate1 = st.executeUpdate(query1);
				System.out.println(noOfRowsUpdate1);
				if (noOfRowsUpdate1 > 0) {
					System.out.println("Updated Sucess fully");
				} else
					System.out.println("Not Updated");
				break;
			case 2:
				System.out.println("Enter the password you wish to update");
				String password = sc.next();
				String query2 = "update instagram set password = '" + password + "' where id = '" + id + "'";
				int noOfRowsUpdate2 = st.executeUpdate(query2);
				System.out.println(noOfRowsUpdate2);
				if (noOfRowsUpdate2 > 0) {
					System.out.println("Updated Sucess fully");
				} else
					System.out.println("Not Updated");
				break;
			case 3:
				System.out.println("Enter the eMail you wish to update");
				String eMail = sc.next();
				String query3 = "update instagram set eMail = '" + eMail + "' where id = '" + id + "'";
				int noOfRowsUpdate3 = st.executeUpdate(query3);
				System.out.println(noOfRowsUpdate3);
				if (noOfRowsUpdate3 > 0) {
					System.out.println("Updated Sucess fully");
				} else
					System.out.println("Not Updated");
				break;
			case 4:
				System.out.println("Enter the DOB you wish to update");
				String dob = sc.next();
				String query4 = "update instagram set dob = '" + dob + "' where id = '" + id + "'";
				int noOfRowsUpdate4 = st.executeUpdate(query4);
				System.out.println(noOfRowsUpdate4);
				if (noOfRowsUpdate4 > 0) {
					System.out.println("Updated Sucess fully");
				} else
					System.out.println("Not Updated");
				break;
			case 5:
				System.out.println("Enter the profession you wish to update");
				String profession = sc.next();
				String query5 = "update instagram set profession = '" + profession + "' where id = '" + id + "'";
				int noOfRowsUpdate5 = st.executeUpdate(query5);
				System.out.println(noOfRowsUpdate5);
				if (noOfRowsUpdate5 > 0) {
					System.out.println("Updated Sucess fully");
				} else
					System.out.println("Not Updated");
				break;

			default:
				System.out.println("Invalid statement");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException | NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class DeleteRow {
	public static void deleteRow() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--> For Delete the Row");
		System.out.println("Enter id");
		String id = sc.next();
		int num = Integer.parseInt(id);
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/server_1", "root", "root");
			Statement st = con.createStatement();
			String query = "delete from instagram where id = '" + num + "'";
			int noOfRowsUpdate = st.executeUpdate(query);
			System.out.println(noOfRowsUpdate);
			if (noOfRowsUpdate > 0) {
				System.out.println("Delete the row Successfully");
			} else {
				System.out.println("Not deleted");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException | NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class FetchData {
	public static void fetchData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--> For fetch data");
		System.out.println("Enter the id to fetch you wish");
		String id = sc.next();
		int num = Integer.parseInt(id);
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/server_1", "root", "root");
			Statement st = con.createStatement();
			String query = "select * from instagram where id = '" + num + "'";
			ResultSet rs = st.executeQuery(query);
			// System.out.println(rs);
			while (rs.next()) {
				System.out.println("==============================");
				System.out.println("Id - " + rs.getString("id"));
				System.out.println("UserName - " + rs.getString("username"));
				System.out.println("Password - " + rs.getString("password"));
				System.out.println("Email - " + rs.getString("email"));
				System.out.println("DOB - " + rs.getString("dob"));
				System.out.println("Profession - " + rs.getString("profession"));
				System.out.println("==============================");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException | NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class MainClass {
	public static void main(String[] args) {
		 InsertData.insertData();
		 Updatedata.updateData();
		 FetchData.fetchData();
		 DeleteRow.deleteRow();
		 
	}
}
