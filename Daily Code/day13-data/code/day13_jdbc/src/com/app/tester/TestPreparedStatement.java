package com.app.tester;

import java.sql.*;
import java.util.Scanner;

import static com.app.utils.DBUtils.openConnection;

public class TestPreparedStatement {

	public static void main(String[] args) {
		try (Scanner sc=new Scanner(System.in);
				// get db connection
				Connection cn = openConnection();
				// create pre-compiled statement to hold the SQL
				PreparedStatement pst = cn.prepareStatement("select * from users where email=? and password =?")){
			System.out.println("Enter username and password:");
			//set IN parameters:public void setType(int paramIndex, Tye values) throws SQLException
			pst.setString(1, sc.next());
			pst.setString(2, sc.next());
			//exec query
			try(ResultSet rst=pst.executeQuery())
			{
				if(rst.next()) {
					System.out.println("Login successfull, Hello "+rst.getString(2));
				}
				else {
						System.out.println("Invalid Login, email or password.");
					}
				}
			}
		 // JVM : cn.close(),rst.close(),st.close()=>cleaning up of DB resources
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
