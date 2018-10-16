package com.lab_mngt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lab_mngt.model.LOLoginModel;
import com.lab_mngt.services.LOLoginServices;


public class LOLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html;charset=UTF-8");
	        try (PrintWriter out = response.getWriter()) {
	            LOLoginModel login = new LOLoginModel();
	           login.setUserName(request.getParameter("userName"));
	           String username=request.getParameter("userName");
	            HttpSession session=request.getSession();
	            session.setAttribute("userName", username);
	            login.setPassWord(request.getParameter("passWord"));
	            
	           
	            LOLoginServices service = new LOLoginServices();
	            int result = service.match(login);
	            
	            if (result == 1) {
	      
	    			//session.setAttribute("userName",username);
	    			//session.setAttribute("userType","LOLoginpage");
	            	 response.getWriter().println("<h2>&nbsp;&nbsp;&nbsp;&nbsp;<font color='black'>Welcome&nbsp&nbsp"+username +"</font></h2>");

	    			
	    			
	    			System.out.println(username);
	            	String redirectUrl="loHomePage.jsp";
	                response.sendRedirect(redirectUrl);
	            } else {
	            	out.print("<center><h3 style='color:red'>Sorry UserName or Password did not match! </h3> <center>");  
	                RequestDispatcher rd=request.getRequestDispatcher("loLogin.jsp");  
	                rd.include(request, response);
	            	 
	            }
	}

	}
}
