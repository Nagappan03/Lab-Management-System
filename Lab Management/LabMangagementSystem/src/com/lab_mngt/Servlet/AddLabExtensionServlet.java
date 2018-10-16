package com.lab_mngt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lab_mngt.dao.LabResultsDao;
import com.lab_mngt.model.LabRequestModel;
import com.lab_mngt.services.AddLabExtensionService;

/**
 * Servlet implementation class AddLabExtensionServlet
 */
public class AddLabExtensionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LabResultsDao dao=new LabResultsDao();
		HttpSession session=request.getSession(false);
		String loName=(String) session.getAttribute("userName");
		List<Integer> reqList=dao.getLoReqList(loName);
		
		request.setAttribute("reqList", reqList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/addLabExtension.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//int reqId=Integer.parseInt(request.getParameter("req_id"));
		int reqId=Integer.parseInt(request.getParameter("reqList"));
		
		LabResultsDao dao=new LabResultsDao();
		int labId=dao.getReqLabId(reqId);
		String labName=dao.getReqLabName(reqId);
		String toDate=request.getParameter("todate");
		HttpSession session=request.getSession(false);
		String loName=request.getParameter("loname");
		
		LabRequestModel req = new LabRequestModel();
		req.setReq_id(reqId);
		req.setLabId(labId);	
		req.setLabName(labName);
		
		
		
		req.setToDate(toDate);
		req.setLoName(loName);
		req.setApproveStatus("pending");
		AddLabExtensionService service = new AddLabExtensionService();
		
		
		int result = service.insert(req);

		if (result == 1) {

			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Lab Extension Request sent Successfully ');");
			out.println("window.location= 'loHomePage.jsp';");
			out.println("</script>");
			

			
		}

		else {
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Lab Extension Request not sent ');");
			out.println("window.location= 'loHomePage.jsp';");
			out.println("</script>");

		}
	}

}
