package com.lab_mngt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab_mngt.model.LabRequestModel;

import com.lab_mngt.services.DeclineRequestService;

/**
 * Servlet implementation class DeclineLabRequestServlet
 */
public class DeclineLabRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		LabRequestModel req = new LabRequestModel();
		req.setReq_id(Integer.parseInt(request.getParameter("req_id")));
		
		DeclineRequestService service = new DeclineRequestService();

		int result = service.decline(req);

		if (result == 1) {
			

			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Lab Request declined');");
			out.println("window.location= 'declineLabRequest.jsp';");
			out.println("</script>");
			
		}

		else {
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invalid Lab Id');");
			out.println("window.location= 'declineLabRequest.jsp';");
			out.println("</script>");

		}
	}

}
