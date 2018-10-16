package com.lab_mngt.services;

import com.lab_mngt.dao.OTHLoginDao;
import com.lab_mngt.model.OTHLoginModel;
public class OTHLoginServices {
	public int match(OTHLoginModel login){
		
		System.out.println("in service....."+login.getUserName());
	     return new OTHLoginDao().match(login);
	 }
}
