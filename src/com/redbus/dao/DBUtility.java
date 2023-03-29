package com.redbus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtility {
	private static String URL;
	private static String USERNAME;
	private static String PASSWORD;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error in loading driver class" + e.getLocalizedMessage());
		}
		ResourceBundle rb = ResourceBundle.getBundle("db");
		URL = rb.getString("url");
		USERNAME = rb.getString("username");
		PASSWORD = rb.getString("password");
	}

	static Connection connectToDB() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	static void close(Connection con) throws SQLException {
		con.close();
	}
}
