package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.PatientDaoImpl;
import com.app.entities.Patient;
import com.app.utils.*;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientDaoImpl patientDao;

	public LoginServlet() {
		System.out.println("in def ctor ");
		System.out.println("config " + getServletConfig());// null
	}
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
    @Override 
	public void init() throws ServletException {
		ServletConfig config1=getServletConfig();
		 try {
			 	DBUtils.openConnection(config1.getInitParameter("db_url"), config1.getInitParameter("user_name"), config1.getInitParameter("password"));
		    	patientDao=new PatientDaoImpl();
		        }
		        catch(Exception e)
		        {
		        	throw new ServletException("err in init - "+getClass(),e);
		        }
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			patientDao.cleanUp();
			DBUtils.closeConnection();
		}
		catch(Exception e)
		{
			System.out.println("err in destroy - "+getClass());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Set Content type
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			String email=request.getParameter("em");
			String password=request.getParameter("pass");
			Patient patient=patientDao.signin(email, password);
			
			if(patient==null) {
				pw.print("<h4>Invalid Login Credentials.</h4><br>");
				pw.print("<a href='index.html'>Retry</a>");
			}else
			{
				HttpSession session= request.getSession();
				session.setAttribute("patient_details", patient);
				session.setAttribute("patient_dao", patientDao);
				pw.print("<h4> Hello, "+patient.getName());
				pw.print("<h5><a href='appointment.html'>Create Appointment</a></h5>");
			}
		}
		catch (Exception e) {
			// inform the WC about the exc
			throw new ServletException("err in servicing " + getClass(), e);
		}
	}

}
