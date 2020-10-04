package com.vn.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {

	public static Connection getConnection() {
		try {
			// 1. Create driver
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Connection
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store", "root", "");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
