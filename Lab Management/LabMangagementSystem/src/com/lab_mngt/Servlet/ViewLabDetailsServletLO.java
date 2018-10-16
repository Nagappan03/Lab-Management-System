package com.lab_mngt.Servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lab_mngt.dao.LabResultsDao;
import com.lab_mngt.model.LabResultsModel;



public class ViewLabDetailsServletLO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In ViewLabDetailsServlet doGet method");
		LabResultsDao dao=new LabResultsDao();
		List<LabResultsModel> list=dao.getResults();
		//System.out.println("size:"+list.size());
	   
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/viewLabInfoLO.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
