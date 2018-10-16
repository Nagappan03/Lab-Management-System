package com.lab_mngt.services;

import com.lab_mngt.dao.OTMLoginDao;
import com.lab_mngt.model.LOLoginModel;
import com.lab_mngt.model.OTHLoginModel;
import com.lab_mngt.model.OTMLoginModel;
public class OTMLoginServices {
	public int match(OTMLoginModel login){
	     return new OTMLoginDao().match(login);
	 }
}
