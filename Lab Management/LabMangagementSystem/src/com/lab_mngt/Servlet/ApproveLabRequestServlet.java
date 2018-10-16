package com.lab_mngt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab_mngt.model.LabRequestModel;

import com.lab_mngt.services.ApproveRequestService;


/**
 * Servlet implementation class ApproveLabRequestServlet
 */
public class ApproveLabRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		LabRequestModel req = new LabRequestModel();
		req.setReq_id(Integer.parseInt(request.getParameter("req_id")));
		System.out.println("this is approve lab request servlet"+request.getParameter("req_id"));
		
		ApproveRequestService service = new ApproveRequestService();

		int result = service.approve(req);

		if (result == 1) {
			
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Lab Request approved');");
			out.println("window.location= 'approveLabRequest.jsp';");
			out.println("</script>");
			
		}

		else {
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invalid Lab Id');");
			out.println("window.location= 'approveLabRequest.jsp';");
			out.println("</script>");

		}
	}

}
