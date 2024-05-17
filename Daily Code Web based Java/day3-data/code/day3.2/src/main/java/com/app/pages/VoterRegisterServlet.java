package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class RegisterServlet
 */
//@WebServlet("/register")
public class VoterRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
		userDao=new UserDaoImpl();
	}catch(Exception e)
		{
		throw new ServletException("err in init - " + getClass(), e);
		}
	}
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			// WC invokes it once @ end of the life cycle
			// clean up Dao
			userDao.cleanUp();
		} catch (Exception e) {
			System.out.println("err in destroy - " + getClass());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. Set response type
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			//Get parameters from the voter_registration form
			String fname=request.getParameter("fn");
			String lname=request.getParameter("ln");
			String email=request.getParameter("em");
			String pass=request.getParameter("pass");
			String date=request.getParameter("dob");
			
			//Creating object of User and passing to registration
			User us=new User(fname, lname, email, pass, Date.valueOf(date));
			
			//Get the period between dob and today.
			Period dperiod=Period.between(LocalDate.parse(date), LocalDate.now());
			int age=dperiod.getYears();
			
			//Check for the age>21
			if(age<21) {
				pw.print("<h4>Underage for voting!!! Please <a href='voter_registration.html'> Retry!</a></h4>");
			}else {
				//Invoke UserDaoImpl method Voter Registration for registration
				String rstatus=userDao.voterRegistration(us);
				pw.print(rstatus+"<h4><a href='login.html'>Login</a>here</h4>");
				
			}
			
		}
		catch(Exception e)
		{
			throw new ServletException("err in servicing \" + getClass(), e");
		}
	}

}
