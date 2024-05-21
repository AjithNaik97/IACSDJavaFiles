package com.app.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import com.app.utils.DBUtils;

import com.app.entities.Appointment;

public class AppointmentDaoImple implements AppointmentDao {
	
	private Connection cn;
	private PreparedStatement pst2;
	
	public AppointmentDaoImple() throws SQLException {
		cn= DBUtils.getConnection();
		pst2=cn.prepareStatement("insert into appointment values(default,?,?,?,?)");
	}

	@Override
	public String createappoint(String pname, String dname, Date doa, Time toa) {
		// TODO Auto-generated method stub
		return null;
	}

}
