package com.app.tester;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.app.dao.AccountDaoImpl;
import com.app.dao.UserDaoImpl;
import com.app.entities.User;

public class TestLayeredJDBCApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// 1. init phase --invoked once @ beginning of app
			// created dao instance (i.e Tester :
			// dependent is creating it's own dependency)
			UserDaoImpl userDao = new UserDaoImpl();
			AccountDaoImpl accountDao = new AccountDaoImpl();
			boolean exit = false;
			while (!exit) {
<<<<<<< HEAD
				System.out.println(
						"Options\n1 : Login \n" + "2 : Display user details by DoB\n" + "3 : Voter registration \n"
								+ "4 : Update Password \n" + "5 : Delete user detail \n" + "0 : Exit");
=======
				System.out.println("Options 1. Login \n" + "2 : Display user details by DoB\n"
						+ "3. Voter registration \n" + "4. Update Password \n" +"5. Delete user\n"+ "0.Exit");
>>>>>>> 5ff5bdedd6e00d178f6a847387d40e7064c4904a
				try {
					switch (sc.nextInt()) {
					case 1: // login
						System.out.println("Enter email n password");
						User user = userDao.signIn(sc.next(), sc.next());
						if (user != null) {
							System.out.println("Login Successful !!!");
							System.out.println(user);
						} else
							System.out.println("Invalid email or password!!!!");
						break;
					case 2:
						System.out.println("Enter start n end DoBs(yr-mon-day)");
						List<User> list = userDao.getUserDetails(Date.valueOf(sc.next()), Date.valueOf(sc.next()));
						System.out.println("Users -");
						list.forEach(System.out::println);// u -> sop(u)
						break;
					case 3:
						System.out.println("Enter Voter's details - firstName,  lastName, email,  password,  dob");
						// create transient(not yet persistent in DB) user instance
						user = new User(sc.next(), sc.next(), sc.next(), sc.next(), Date.valueOf(sc.next()));
						System.out.println("Reg status " + userDao.voterRegistration(user));
						break;

					case 4:
						System.out.println("Enter email, old password and new password:");
						System.out.println(userDao.updatePass(sc.next(), sc.next(), sc.next()));
						break;

					case 5:
<<<<<<< HEAD
						System.out.println("Enter the voter id of user to be deleted:");
						System.out.println(userDao.deleteUser(sc.nextInt()));
						break;

					case 6:

=======
						System.out.println("Enter the voter ID");
						
						
						
>>>>>>> 5ff5bdedd6e00d178f6a847387d40e7064c4904a
						break;
					case 0:
						exit = true;
						// destroy (shutdown/terminate app)
						userDao.cleanUp();
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
