package com.lab_mngt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lab_mngt.model.LabRequestModel;
import com.lab_mngt.utils.ConnectionUtils;

public class DeclineReleaseRequestDao {
	int result=0;


	public int decline(LabRequestModel req)

	{

	try {

	Connection con=ConnectionUtils.getConnection();

	System.out.println(con);

	PreparedStatement pst=con.prepareStatement("update release_request_details set approve_status='Not Approved' where req_id=?");
	
	pst.setInt(1, req.getReq_id());
	result=pst.executeUpdate();

	} catch (SQLException e) {
	e.printStackTrace();

	}
	return result;
	}

}
