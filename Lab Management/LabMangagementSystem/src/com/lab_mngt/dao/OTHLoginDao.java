package com.lab_mngt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lab_mngt.model.LOLoginModel;
import com.lab_mngt.model.OTHLoginModel;
import com.lab_mngt.utils.ConnectionUtils;


public class OTHLoginDao {

	String pwdFromDb = null;
	String usrnameFromDb = null;
    public int match(OTHLoginModel login) {
    	int result=0;
    	Connection con=null;
        System.out.println("match method of OTHLoginDAO class.....");
        
        try {

             con = ConnectionUtils.getConnection();
            System.out.println("hello");
           
            PreparedStatement ps=con.prepareStatement("select * from othLogin where username=? and password=?");
            ps.setString(1,login.getUserName());
            ps.setString(2,login.getPassWord());
          
          //result=ps.executeUpdate();
            ResultSet rs = ps.executeQuery();
            System.out.println("h111");
            while(rs.next()){
            	usrnameFromDb=rs.getString("USERNAME");
                pwdFromDb = rs.getString("PASSWORD");
                System.out.println("h1");
                if(pwdFromDb.equals(login.getPassWord()) && usrnameFromDb.equals(login.getUserName()))
                {
                     /*result= 1;*/
                	System.out.println("pwdFromDb" +pwdFromDb);
                	System.out.println("usrnameFromDb" +usrnameFromDb);
                     System.out.println(result);
                     result= 1;
                    
                }
                else
                {
                    
                    System.out.println(result);
                    result= 0;
                    
                    
                }
            
            }
        }
        catch(Exception e){
            e.printStackTrace();
           
        }
        finally{
    		try {
    			con.close();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
		return result;
		
    }
}
