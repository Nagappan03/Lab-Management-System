package com.lab_mngt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.lab_mngt.model.LabRequestModel;
import com.lab_mngt.model.LabResultsModel;
import com.lab_mngt.utils.ConnectionUtils;


public class LabResultsDao {
	public List<LabResultsModel> getResults(){
		List<LabResultsModel> list=new ArrayList<LabResultsModel>();
		Connection con=null;
		LabResultsModel labResults=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@172.16.153.233:1521:xe","user1","techm123");
			psmt=con.prepareStatement("select * from lab_details");
			rs=psmt.executeQuery();
			while(rs.next()){
				labResults=new LabResultsModel();
				labResults.setLabId(rs.getInt("lab_id"));
				System.out.println(rs.getString("lab_name"));
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
	
	public int getLabId(String labName)
	{
		Connection con=null;
		int labId=0;
		ResultSet rs=null;
		PreparedStatement pst=null;
		
		con=ConnectionUtils.getConnection();
		try {
			pst=con.prepareStatement("select lab_id from lab_details where lab_name=?");
			pst.setString(1,labName);
			rs=pst.executeQuery();
			while(rs.next())
			{
				labId=rs.getInt("lab_id");
			}
			System.out.println("in getLabId\nlab_id:"+labId);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return labId;
		
	}
	
	public List<String> getLabList() {
		Connection con=null;
		List<String> list=new ArrayList<String>();
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//con=DriverManager.getConnection("jdbc:oracle:thin:@hstslc015:1521:elp", "elite0001", "techM123$");
			con=ConnectionUtils.getConnection();
			PreparedStatement psmt=con.prepareStatement("select lab_name from lab_details");
			ResultSet rs=psmt.executeQuery();
			while(rs.next()){
				//int country_code=rs.getInt("COUNTRY_CODE");
				String labName=rs.getString("lab_name");
				list.add(labName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Integer> getLoReqList(String loName) {
		Connection con=null;
		List<Integer> list=new ArrayList<Integer>();
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//con=DriverManager.getConnection("jdbc:oracle:thin:@hstslc015:1521:elp", "elite0001", "techM123$");
			con=ConnectionUtils.getConnection();
			PreparedStatement psmt=con.prepareStatement("select req_id from lab_request_details where lo_name=? and approve_status='Approved'");
			psmt.setString(1, loName);
			ResultSet rs=psmt.executeQuery();
			while(rs.next()){
				//int country_code=rs.getInt("COUNTRY_CODE");
				Integer reqId=rs.getInt("req_id");
				list.add(reqId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int getReqLabId(int reqId) {
		Connection con=null;
		int labId=0;
		ResultSet rs=null;
		PreparedStatement pst=null;
		
		con=ConnectionUtils.getConnection();
		try {
			pst=con.prepareStatement("select labid from lab_request_details where req_id=?");
			pst.setInt(1,reqId);
			rs=pst.executeQuery();
			while(rs.next())
			{
				labId=rs.getInt("labid");
			}
			//System.out.println("in getLabId\nlab_id:"+labId);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return labId;
	}

	public String getReqLabName(int reqId) {
		Connection con=null;
		String labName=null;
		ResultSet rs=null;
		PreparedStatement pst=null;
		
		con=ConnectionUtils.getConnection();
		try {
			pst=con.prepareStatement("select labname from lab_request_details where req_id=?");
			pst.setInt(1,reqId);
			rs=pst.executeQuery();
			while(rs.next())
			{
				labName=rs.getString("labname");
				System.out.println("im at get request lab name"+labName);
			}
			//System.out.println("in getLabId\nlab_id:"+labId);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return labName;
	}

	public List<LabRequestModel> getRequestResults(String loName) throws ClassNotFoundException {
		List<LabRequestModel> list=new ArrayList<LabRequestModel>();
		Connection con=null;
		LabRequestModel labResults=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;

		try {
			    
			
			con=ConnectionUtils.getConnection();
			psmt=con.prepareStatement("select * from lab_request_details where lo_name=? and approve_status='Approved'");
			psmt.setString(1, loName);
			rs=psmt.executeQuery();
			
			while(rs.next()){
				System.out.println("Hi satish123");
				System.out.println(rs.getInt("req_id")+rs.getInt("labid")+rs.getString("labname")+rs.getString("fromdate"));
				labResults=new LabRequestModel();
				labResults.setReq_id(rs.getInt("req_id"));
				labResults.setLabId(rs.getInt("labid"));
				labResults.setLabName(rs.getString("labname"));
				labResults.setFromDate(rs.getString("fromdate"));
				labResults.setToDate(rs.getString("todate"));
				labResults.setLoName(rs.getString("lo_name"));
				labResults.setApproveStatus(rs.getString("approve_status"));
				System.out.println("my approved status");
				
				//System.out.println(rs.getString("lo_name"));
				list.add(labResults);
				for (LabRequestModel labRequestModel : list) {
					System.out.println("this is satish");
					System.out.println(list);
				}
				
			}
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

	public List<LabRequestModel> getReleaseResults(String loName) {
		List<LabRequestModel> list=new ArrayList<LabRequestModel>();
		Connection con=null;
		LabRequestModel labResults=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;

		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//con=DriverManager.getConnection("jdbc:oracle:thin:@hstslc015:1521:elp","elite0001","techM123$");
			con=ConnectionUtils.getConnection();
			psmt=con.prepareStatement("select * from release_request_details where lo_name=?");
			psmt.setString(1, loName);
			rs=psmt.executeQuery();
			while(rs.next()){
				labResults=new LabRequestModel();
				labResults.setReq_id(rs.getInt("req_id"));
				labResults.setLabId(rs.getInt("lab_id"));
				labResults.setLabName(rs.getString("lab_name"));
				labResults.setReleaseDate(rs.getString("release_date"));
				labResults.setLoName(rs.getString("lo_name"));
				labResults.setApproveStatus(rs.getString("approve_status"));
				
				list.add(labResults);
			}
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

	public List<LabRequestModel> getExtensionResults(String loName) {
		List<LabRequestModel> list=new ArrayList<LabRequestModel>();
		Connection con=null;
		LabRequestModel labResults=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;

		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//con=DriverManager.getConnection("jdbc:oracle:thin:@hstslc015:1521:elp","elite0001","techM123$");
			con=ConnectionUtils.getConnection();
			psmt=con.prepareStatement("select * from extension_request_details where lo_name=?");
			psmt.setString(1, loName);
			rs=psmt.executeQuery();
			while(rs.next()){
				labResults=new LabRequestModel();
				labResults.setReq_id(rs.getInt("req_id"));
				labResults.setLabId(rs.getInt("lab_id"));
				labResults.setLabName(rs.getString("lab_name"));
				labResults.setToDate(rs.getString("to_date"));
				labResults.setLoName(rs.getString("lo_name"));
				labResults.setApproveStatus(rs.getString("approve_status"));
				
				list.add(labResults);
			}
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




