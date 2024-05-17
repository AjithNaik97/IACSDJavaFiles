package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.CandidateDaoImpl;
import com.app.entities.Candidate;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CandidateDaoImpl admin;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
		admin=new CandidateDaoImpl();
	}
		catch(Exception e)
		{
			throw new ServletException("err in init"+e);
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			//Getting the list containing top two candidates using method.
			List<Candidate> toplist=admin.getTop2Candidates();
			//printing the list in HTML format using pw.print statement
			pw.print("<h4><u>Top two leading candidates</u></h4>");
			pw.print("<table border=1px><tr><td>ID</td><td>Name</td><td>Party</td><td>Votes</td></tr>");
			//iterating and printing the list toplist
			for(Candidate c:toplist)
				pw.print("<tr><td>"+c.getCandidateId()+"</td><td>"+c.getCandidateName()+"</td><td>"+c.getParty()+"</td><td>"+c.getVotes()+"</td></tr>");
			pw.print("</table>");
			
			//Getting Map of Party wise vote
			pw.print("<h4><u>Vote Analysis (Political Party Wise)</u></h4>");
			pw.print("<table border=1px><tr><td>Party</td><td>Votes</td></tr>");
			admin.getPartyWiseVotes().forEach((key,value)->pw.print("<tr><td>"+key+"</td><td>"+value+"</td></tr>"));
			pw.print("</table>");
			
		}
		catch(Exception e)
		{
			throw new ServletException("err in init"+e);
		}
		
		
	}

}
