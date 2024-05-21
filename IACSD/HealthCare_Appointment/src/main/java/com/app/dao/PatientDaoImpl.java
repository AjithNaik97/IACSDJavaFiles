package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.utils.DBUtils;

import com.app.entities.Patient;

public class PatientDaoImpl implements PatientDao {
	private Connection cn;
	private PreparedStatement pst1;

	public PatientDaoImpl() throws SQLException {
		cn = DBUtils.getConnection();
		
	//pst1: Sign in
		pst1=cn.prepareStatement("select * from Patient where email=? and password=?");
		
	}
	
	//Sign In method

	@Override
	public Patient signin(String email, String password) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, password);
		
		try(ResultSet rst=pst1.executeQuery())
		{
			while(rst.next())
				return new Patient(rst.getInt(1) , rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5));
		}
		
		return null;
	}
	
	//Clean up method
	public void cleanUp() throws SQLException
	{
		if(pst1!=null)
			pst1.close();
	}
	

}
