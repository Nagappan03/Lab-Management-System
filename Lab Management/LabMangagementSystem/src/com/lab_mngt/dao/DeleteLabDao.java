package com.lab_mngt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lab_mngt.model.LabResultsModel;
import com.lab_mngt.utils.ConnectionUtils;


public class DeleteLabDao {

	int result=0;


	public int delete(LabResultsModel req)

	{

	try {

	Connection con=ConnectionUtils.getConnection();

	System.out.println(con);

	PreparedStatement pst=con.prepareStatement("update lab_details set status='deactivated' where lab_id=?");

	pst.setInt(1, req.getLabId());

	result=pst.executeUpdate();

	} catch (SQLException e) {
	e.printStackTrace();

	}
	return result;
	}
}
