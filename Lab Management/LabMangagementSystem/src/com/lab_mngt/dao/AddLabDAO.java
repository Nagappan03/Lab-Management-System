package com.lab_mngt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lab_mngt.model.LabResultsModel;
import com.lab_mngt.utils.ConnectionUtils;


public class AddLabDAO {
	int result=0;


	public int insert(LabResultsModel req)

	{

	try {

	Connection con=ConnectionUtils.getConnection();

	System.out.println("this is add lab Dao"+con);

	PreparedStatement pst=con.prepareStatement("insert into lab_details values(SQ_LABID.nextval,?,?,?,?,?,?,?,?,?)");


	pst.setString(1, req.getLabName());
	pst.setInt(2,req.getCapacity());
	pst.setString(3,req.getType());
	String s=req.getType();
	pst.setString(4,req.getLocation());
	pst.setInt(5,req.getNoOfSystems());
	pst.setString(6,req.getProjector());
	pst.setString(7,req.getVcFacility());
	pst.setInt(8,req.getNoOfWhiteBoards());
	pst.setString(9,req.getStatus());
	



	result=pst.executeUpdate();

	} catch (SQLException e) {
	e.printStackTrace();

	}
	return result;

	}

}

