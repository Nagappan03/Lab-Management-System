package com.lab_mngt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab_mngt.model.LabResultsModel;
import com.lab_mngt.services.DeleteLabService;


public class DeleteLabServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		LabResultsModel req = new LabResultsModel();
		req.setLabId(Integer.parseInt(request.getParameter("LabId")));
		
		DeleteLabService service = new DeleteLabService();

		int result = service.delete(req);

		if (result == 1) {
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Lab Successfully deleted');");
			out.println("window.location= 'othHomePage.jsp';");
			out.println("</script>");
			
			
		}

		else {
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invalid Lab Id');");
			out.println("window.location= 'deletelab.jsp';");
			out.println("</script>");

		}

	}
	

}
