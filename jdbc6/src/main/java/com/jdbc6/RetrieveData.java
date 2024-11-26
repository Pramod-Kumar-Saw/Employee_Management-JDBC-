package com.jdbc6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveData {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_2", "root", "root");
			Statement st = connection.createStatement();
			String query = "select * from employee_1";
		//	int noOfRowsUpdated = st.executeUpdate(query);
		//	System.out.println(noOfRowsUpdated);
			boolean isSelect = st.execute(query);
		//	System.out.println(isSelect);
			if(isSelect)
			{
				ResultSet set = st.getResultSet();
				while(set.next())
				{
					System.out.println("id - "+set.getString("id"));
					System.out.println("name - "+set.getString("name"));
					System.out.println("email - "+set.getString("email"));
					System.out.println("age - "+set.getString("age"));
					System.out.println("=======================");
				}
			}
			else
			{
				int updateCount = st.getUpdateCount();
				System.out.println(updateCount);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException | NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
