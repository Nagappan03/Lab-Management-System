package com.lab_mngt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab_mngt.model.LabResultsModel;
import com.lab_mngt.services.AddLabService;



public class AddLabServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		LabResultsModel req = new LabResultsModel();
		//req.setLabId(Integer.parseInt(request.getParameter("LabID")));
		req.setLabName(request.getParameter("LabName"));	
		req.setCapacity(Integer.parseInt(request.getParameter("capacity")));
		
		
		req.setType(request.getParameter("type"));
		req.setLocation(request.getParameter("LabLocation"));
		req.setNoOfSystems(Integer.parseInt(request.getParameter("no_of_systems")));
		req.setProjector(request.getParameter("projector"));
		req.setVcFacility(request.getParameter("VC_Facility"));
		req.setNoOfWhiteBoards(Integer.parseInt(request.getParameter("no_white_boards")));
		req.setStatus(request.getParameter("Status"));
		AddLabService service = new AddLabService();

		int result = service.insert(req);

		if (result == 1) {

			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Lab Successfully Added');");
			out.println("window.location= 'othHomePage.jsp';");
			out.println("</script>");
			
		}

		else {
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Lab not added');");
			out.println("</script>");

		}

	}
	}

