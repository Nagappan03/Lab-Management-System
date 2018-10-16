package com.lab_mngt.services;

import com.lab_mngt.dao.AddLabDAO;
import com.lab_mngt.dao.AddLabRequestDao;
import com.lab_mngt.model.LabRequestModel;
import com.lab_mngt.model.LabResultsModel;

public class AddLabRequestService {

	public int insert(LabRequestModel req)

	{

		return new AddLabRequestDao().insert(req);

	}

}
