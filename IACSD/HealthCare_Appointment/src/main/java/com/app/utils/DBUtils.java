package com.app.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection connection;
	
	public static void openConnection(String DB_URL, String USER_NAME, String PASSWORD) throws SQLException, ClassNotFoundException{
		connection=DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
	}

	public static Connection getConnection() {
		return connection;
	}
	
	public static void closeConnection() throws SQLException{
		if(connection!=null)
			connection.close();
		System.out.println("db connection closed!");
	}
}
