package com.lab_mngt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lab_mngt.model.LabRequestModel;
import com.lab_mngt.utils.ConnectionUtils;

public class ApproveExtensionRequestDao {

	int result=0;


	public int approve(LabRequestModel req)

	{

	try {

	Connection con=ConnectionUtils.getConnection();

	System.out.println(con);

	PreparedStatement pst=con.prepareStatement("update extension_request_details set approve_status='Approved' where req_id=?");
	PreparedStatement pst1=con.prepareStatement("update lab_request_details set to_date=? where req_id=?");
	
	pst.setInt(1, req.getReq_id());
	int reqID=(req.getReq_id());
	PreparedStatement pst2=con.prepareStatement("select to_date from extension_request_details where req_id=?");
	pst2.setInt(1,req.getReq_id() );
	ResultSet rs=pst2.executeQuery();
	String to_date=null;
	while(rs.next())
	{
		to_date=rs.getString("to_date");
		
	}
	pst1.setString(1, to_date);
	pst1.setInt(2,req.getReq_id());
	result=pst.executeUpdate();
	pst1.executeUpdate();

	} catch (SQLException e) {
	e.printStackTrace();

	}
	return result;
	}
}
