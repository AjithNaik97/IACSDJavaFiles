package com.app.dao;

import java.sql.Connection;
import java.sql.*;
import static com.app.utils.DBUtils.*;


public class AccountDaoImpl implements AccountDao{
	//state
	private Connection cn;
	private CallableStatement cst1;
	
	//def ctor
	public AccountDaoImpl() throws SQLException {
		//get db cn from utils
		cn=openConnection();
		//create CST to invoke stored proc
		cst1=cn.prepareCall("{call transfer_funds_proc(?,?,?,?,?)}");
		//register Out params
		cst1.registerOutParameter(4,Types.DOUBLE);
		cst1.registerOutParameter(5, Types.DOUBLE);
		System.out.println("Account dao created");
	}

	@Override
	public String transferFund(int srcAcNo, int destAcNo, double amount) throws SQLException
	{
		//1.set IN params
		cst1.setInt(1, srcAcNo);
		cst1.setInt(2, destAcNo);
		cst1.setDouble(3, amount);
		//execute proc
		cst1.execute();
		return "Updated src balance "+ cst1.getDouble(4)+" dest balance "+cst1.getDouble(5);
	}
	
	//clean up
	public void cleanUp() throws SQLException{
		if(cst1!=null)
			cst1.close();
	}
}
