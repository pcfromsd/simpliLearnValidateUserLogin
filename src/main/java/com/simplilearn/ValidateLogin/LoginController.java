/*
Validation of the User Login.
DESCRIPTION

Project objective:
Create a servlet-based web application that shows a login page and validates it. 
The correct values are hard-coded. On successful login, a dashboard page is shown. 
The dashboard will provide a link for logging out. 
Incorrect logins need to be handled by showing an error message page.

Background of the problem statement:
As a part of developing an e-commerce web application, you have to prototype a login scenario for the user. 
There is no database involved here, so you have to use fixed values for login email id and password.

You must use the following:
    - Eclipse as the IDE
    - Apache Tomcat as the web server
    - HTML pages for the front end
    - Servlets for backend processing
 
Following requirements should be met:
    - Show a login form in HTML
    - Handle invalid logins and show appropriate error messages using servlets
    - Show the dashboard page using servlets
    - Handle logouts using servlets
    - Document the step-by-step process involved in completing this task 
*/

package com.simplilearn.ValidateLogin;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
* Servlet implementation class LoginController
*/
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
    * Default constructor. 
    */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	* @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		RequestDispatcher rd = null;
		if (username.equalsIgnoreCase("purnendu") && password.equalsIgnoreCase("Xyz123")) {
			rd = request.getRequestDispatcher("SuccessServlet");
			rd.forward(request, response);
		}
		else {
			rd = request.getRequestDispatcher("login.html");
			PrintWriter out = response.getWriter();
			rd.include(request, response);
			out.println("<center><span style='color:red'>Invalid Credentials!</span></center>");
		}
	}

}
