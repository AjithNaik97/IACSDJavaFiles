package com.app.beans;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.sql.Date;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

public class UserBean {
//state -- request params from clnt mapped to Java bean properties
	private String email;
	private String password;
	private String fn;
	private String ln;
	private String dob;
	
	//dependency -- dao layer
	private UserDaoImpl userDao;
	//add a property to store validated user details
	private User userDetails;
	private String message;
	//def ctor 
	public UserBean() throws SQLException{
		// create dao instance
		userDao=new UserDaoImpl();
		System.out.println("user bean created...");
	}
	//getter n setter
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserDaoImpl getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}
	public User getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	//Add B.L method for user authentication
	public String validateUser() throws SQLException{
		System.out.println("in validate user "+email+" "+password);
		//bean --> invokes dao's method
		userDetails=userDao.signIn(email, password);
		if(userDetails == null) {
			//invalid login
			message="Invalid Email or Password , Please retry!";
			return "login";
		}
		//=> valid login --> chk role based authorization
		message="Login Successful!";
		if(userDetails.getRole().equals("admin"))
			return "admin_main";
		//=> voter login
		if(userDetails.isStatus())
			return "logout";
		//not yet voted
		return "candidate_list";
	}
	
	//add a B.L method for validating ips and then registration
	public String validateAndRegister() throws SQLException {
		
	//parse dob -->LocalDate and validate
		//in case invalid age --return err message
		//o.w invoke dao's method for reg.
		
		LocalDate date=LocalDate.parse(dob);
		int period=Period.between(date, LocalDate.now()).getYears();
		if(period<21)
			return "Underage for voting!!";
		User voter=new User(fn, ln, email, password, Date.valueOf(date));
		return userDao.voterRegistration(voter);
	}
	
	
}
