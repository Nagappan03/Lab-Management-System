package com.lab_mngt.services;

import com.lab_mngt.dao.AddLabDAO;
import com.lab_mngt.model.LabResultsModel;



public class AddLabService {
	int result = 0;

	public int insert(LabResultsModel req)

	{

		return new AddLabDAO().insert(req);

	}

}



