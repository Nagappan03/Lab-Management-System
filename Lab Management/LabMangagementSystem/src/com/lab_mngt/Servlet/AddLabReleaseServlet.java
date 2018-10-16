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
import com.lab_mngt.services.AddLabReleaseService;

/**
 * Servlet implementation class AddLabReleaseServlet
 */
public class AddLabReleaseServlet extends HttpServlet {
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
		
		RequestDispatcher rd=request.getRequestDispatcher("/addReleaseRequest.jsp");
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
		System.out.println("i am at realease lab request "+ labId);
		String labName=dao.getReqLabName(reqId);
		String releaseDate=request.getParameter("releasedate");
		HttpSession session=request.getSession(false);
		String loName=request.getParameter("loname");
		
		LabRequestModel req = new LabRequestModel();
		req.setReq_id(reqId);
		req.setLabId(labId);	
		req.setLabName(labName);
		
		req.setReleaseDate(releaseDate);
		req.setLoName(loName);
		req.setApproveStatus("Pending");
		AddLabReleaseService service = new AddLabReleaseService();
		
		
		int result = service.insert(req);

		if (result == 1) {

			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Lab Release Request sent successfully');");
			out.println("window.location= 'loHomePage.jsp';");
			out.println("</script>");
		}

		else {
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Lab Release Request not sent');");
			out.println("window.location= 'loHomePage.jsp';");
			out.println("</script>");

		}
	}

}
