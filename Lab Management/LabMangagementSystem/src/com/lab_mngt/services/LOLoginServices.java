package com.lab_mngt.services;

import com.lab_mngt.dao.LOLoginDao;
import com.lab_mngt.model.LOLoginModel;
import com.lab_mngt.model.LOLoginModel;
public class LOLoginServices {
	
	
	
	
	public int match(LOLoginModel login){
		
		System.out.println("in service....."+login.getUserName());
	     return new LOLoginDao().match(login);
	     
	     
	 }
}
