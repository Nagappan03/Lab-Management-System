package com.lab_mngt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lab_mngt.model.LabRequestModel;
import com.lab_mngt.utils.ConnectionUtils;

public class AddLabRequestDao {
	int result = 0;

	public int insert(LabRequestModel req)

	{

		try {

			Connection con = ConnectionUtils.getConnection();

			System.out.println(con);
            System.out.println("Add lab request");
			PreparedStatement pst = con.prepareStatement("insert into lab_request_details values(sq_reqid.nextval,?,?,?,?,?,?)");

			pst.setInt(1, req.getLabId());
			pst.setString(2, req.getLabName());
			pst.setString(3, req.getFromDate());
			System.out.println(req.getFromDate());

			pst.setString(4, req.getToDate());
			System.out.println(req.getToDate());
			pst.setString(5, req.getLoName());
			pst.setString(6, req.getApproveStatus());

			result = pst.executeUpdate();
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return result;

	}

	public int insertExtension(LabRequestModel req) {
		
		try {

			Connection con = ConnectionUtils.getConnection();

			System.out.println(con);

			PreparedStatement pst = con.prepareStatement("insert into extension_request_details values(?,?,?,?,?,?)");
			pst.setInt(1, req.getReq_id());
			pst.setInt(2, req.getLabId());
			pst.setString(3, req.getLabName());
			pst.setString(4, req.getToDate());
			pst.setString(5, req.getLoName());
			pst.setString(6, req.getApproveStatus());

			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return result;

	}
public int insertRelease(LabRequestModel req) {
		
		try {

			Connection con = ConnectionUtils.getConnection();

			System.out.println(con);
			System.out.println("im at AddLabRequestDao.insertRelease");

			PreparedStatement pst = con.prepareStatement("insert into release_request_details values(?,?,?,?,?,?)");
			pst.setInt(1, req.getReq_id());
			pst.setInt(2, req.getLabId());
			pst.setString(3, req.getLabName());
			pst.setString(4, req.getReleaseDate());
			pst.setString(5, req.getLoName());
			pst.setString(6, req.getApproveStatus());

			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return result;

	}

}
