package com.app.dao;

import java.sql.SQLException;

import com.app.entities.Patient;

public interface PatientDao {
	Patient signin(String email,String password) throws SQLException;
}
