package com.lab_mngt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab_mngt.model.OTHLoginModel;
import com.lab_mngt.services.OTHLoginServices;

/**
 * Servlet implementation class OTHLoginServlet
 */
public class OTHLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            OTHLoginModel login = new OTHLoginModel();
            login.setUserName(request.getParameter("userName"));
            login.setPassWord(request.getParameter("passWord"));

            OTHLoginServices service = new OTHLoginServices();
            int result = service.match(login);
            if (result == 1) {
            	 String username = null;
				response.getWriter().println("<h2>&nbsp;&nbsp;&nbsp;&nbsp;<font color='black'>Welcome&nbsp&nbsp"+username +"</font></h2>");
            	String redirectUrl="othHomePage.jsp";
                response.sendRedirect(redirectUrl);
            } else {
            	out.print("<center><h3 style='color:red'>Sorry UserName or Password did not match!</h3><center>");  
                RequestDispatcher rd=request.getRequestDispatcher("othLogin.jsp");  
                rd.include(request, response);
                
            }
        }
    }
}
