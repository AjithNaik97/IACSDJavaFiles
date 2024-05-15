package com.app.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.app.entities.User;

public interface UserDao {
//add a method for user's signin
	User signIn(String email, String password) throws SQLException;

	// add a method for getting user details(not admin) born between dates
	List<User> getUserDetails(Date begin, Date end) throws SQLException;
	// add a method for voter reg.
	String voterRegistration(User newVoter) throws SQLException;
	//update Password
	String updatePass(String email, String old_password, String new_password) throws SQLException;
<<<<<<< HEAD
	//delete user details
	String deleteUser(int id) throws SQLException;
=======
	
	
>>>>>>> 5ff5bdedd6e00d178f6a847387d40e7064c4904a
}
