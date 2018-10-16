package com.lab_mngt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.lab_mngt.dao.LabResultsDao;
import com.lab_mngt.model.LabRequestModel;
import com.lab_mngt.model.LabResultsModel;
import com.lab_mngt.services.AddLabRequestService;
import com.lab_mngt.services.AddLabService;

/**
 * Servlet implementation class AddLabRequestServlet
 */
public class AddLabRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LabResultsDao dao=new LabResultsDao();
		List<String> labList=dao.getLabList();
		
		request.setAttribute("labList", labList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/addLabRequest.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String labName=request.getParameter("labList");
		
		LabResultsDao dao=new LabResultsDao();
		int labId=dao.getLabId(labName);
		
		String fromDate=request.getParameter("fromdate");
		String toDate=request.getParameter("todate");
		HttpSession session=request.getSession(false);
		String loName=request.getParameter("loname");
		
		LabRequestModel req = new LabRequestModel();
		req.setLabId(labId);	
		req.setLabName(labName);
		
		
		req.setFromDate(fromDate);
		req.setToDate(toDate);
		req.setLoName(loName);
		req.setApproveStatus("Pending");
		AddLabRequestService service = new AddLabRequestService();
		
		
		int result = service.insert(req);

		if (result == 1) {

			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Lab Request sent successfully ');");
			out.println("window.location= 'loHomePage.jsp';");
			out.println("</script>");

		}

		else {
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Lab  Request not sent ');");
			out.println("window.location= 'loHomePage.jsp';");
			out.println("</script>");

		}
		
		
	}

}

