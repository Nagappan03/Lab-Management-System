package com.lab_mngt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab_mngt.model.OTMLoginModel;
import com.lab_mngt.services.OTMLoginServices;


public class OTMLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html;charset=UTF-8");
	        try (PrintWriter out = response.getWriter()) {
	            OTMLoginModel login = new OTMLoginModel();
	            login.setUserName(request.getParameter("userName"));
	            login.setPassWord(request.getParameter("passWord"));

	            OTMLoginServices service = new OTMLoginServices();
	            int result = service.match(login);
	            if (result == 1) {
	            	String redirectUrl="otmHomePage.jsp";
	                response.sendRedirect(redirectUrl);
	            } else {
	            	out.print("<center><h3 style='color:red'>Sorry UserName or Password did not match!</h3><center>");  
	                RequestDispatcher rd=request.getRequestDispatcher("otmLogin.jsp");  
	                rd.include(request, response);
	            	 
	            }
	}

	}
}
