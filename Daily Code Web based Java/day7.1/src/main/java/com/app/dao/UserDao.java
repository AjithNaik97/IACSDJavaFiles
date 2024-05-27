package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import com.app.entities.Role;
import com.app.entities.User;

public interface UserDao {
//add a method for user sign up
	String registerUser(User user);
	//add a method to get user details by it's id
	User getUserDetails(Long userId);
	// add a method to return list of all users
	List<User> getAllUser();
	//add a method to return list of users by dob and role
	List<User> getUserByDobandRole(LocalDate start,LocalDate end, Role role);
	User authenticateUser(String email, String password);
	String changePassword(String email, String oldpassword, String newpassword);
}
