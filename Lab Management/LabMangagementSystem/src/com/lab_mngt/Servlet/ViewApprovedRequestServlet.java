package com.lab_mngt.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lab_mngt.dao.LabResultsDao;
import com.lab_mngt.model.LabRequestModel;
import com.lab_mngt.model.LabResultsModel;

/**
 * Servlet implementation class ViewApprovedRequestServlet
 */
public class ViewApprovedRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("In ViewLabDetailsServlet doGet method");
		LabResultsDao dao=new LabResultsDao();
		HttpSession session=request.getSession(false);
		String loName=(String) session.getAttribute("userName");
		
		System.out.println(loName);
		List<LabRequestModel> list = null;
		try {
			list = dao.getRequestResults(loName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("size:"+list.size());
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/viewLabRequestInfo.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
