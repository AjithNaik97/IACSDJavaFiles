package web_pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */

/*
 * Run time annotation, class level, mandatory annotation meant for Webcontainer(WC)
 * when you deploy a web app, WC creates a Map
 * key-url pattern
 * value--F.Q[Fully Qualified] servlet class name(web_pages.TestServlet)
 * URl--https://host (localhost) :port (8080)/day1_lab/hello http--app layer
 * protocol (scheme) host--DNS qualified host name(www.abc.com) or IP Address
 * port--TCP port no(def port-8080) URL(Uniform Resource Identifier)--/day1_lab
 *hello--URL Pattern
 */
@WebServlet("/hello")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("in init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Set response content type
		System.out.println("in doGet");
		response.setContentType("text/html");
		//2. Get PW from HttpServerResponse, to send buffered text contents --> to the client
		try(PrintWriter pw=response.getWriter())
		{
			//add dynamic contents to PW's buffer
			pw.print("<h4> Hello from servlets..."+LocalDateTime.now()+"</h4>");
		}
	}

}
