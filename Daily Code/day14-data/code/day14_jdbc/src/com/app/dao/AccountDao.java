package com.app.dao;

import java.sql.SQLException;

public interface AccountDao {
	String transferFund(int srcAcNo, int destAcNo, double amount) throws SQLException;
}
