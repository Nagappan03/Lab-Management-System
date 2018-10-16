package com.lab_mngt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.lab_mngt.model.LabResultsModel;
import com.lab_mngt.utils.ConnectionUtils;
public class ViewLabRequestDao {
	public List<LabResultsModel> getResults(){
		List<LabResultsModel> list=new ArrayList<LabResultsModel>();
		Connection con=null;
		LabResultsModel labResults=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@172.16.153.233:xe","user1","techm123");
			psmt=con.prepareStatement("select * from lab_request_details");
			rs=psmt.executeQuery();
			while(rs.next()){
				labResults=new LabResultsModel();
				labResults.setLabId(rs.getInt("lab_id"));
				labResults.setLabName(rs.getString("lab_name"));
				labResults.setCapacity(rs.getInt("capacity"));
				labResults.setType(rs.getString("type"));
				labResults.setLocation(rs.getString("location"));
				labResults.setNoOfSystems(rs.getInt("no_of_systems"));
				labResults.setProjector(rs.getString("projector"));
				labResults.setVcFacility(rs.getString("vc_facility"));
				labResults.setNoOfWhiteBoards(rs.getInt("no_white_boards"));
				labResults.setStatus(rs.getString("status"));
				list.add(labResults);
			}
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	   return list;
		
	}
}