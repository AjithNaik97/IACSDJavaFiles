package com.app.dao;

import java.sql.Date;
import java.sql.Time;

import com.app.entities.Appointment;

public interface AppointmentDao {
	String createappoint(String pname, String dname, Date doa, Time toa);
}
