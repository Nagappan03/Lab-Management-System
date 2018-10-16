package com.lab_mngt.services;

import com.lab_mngt.dao.AddLabRequestDao;
import com.lab_mngt.model.LabRequestModel;

public class AddLabExtensionService {
	public int insert(LabRequestModel req)

	{

		return new AddLabRequestDao().insertExtension(req);

	}

}
