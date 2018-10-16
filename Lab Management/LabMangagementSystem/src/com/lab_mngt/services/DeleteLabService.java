package com.lab_mngt.services;

import com.lab_mngt.dao.DeleteLabDao;
import com.lab_mngt.model.LabResultsModel;



public class DeleteLabService {
	int result = 0;

	public int delete(LabResultsModel req)

	{

		return new DeleteLabDao().delete(req);

	}

}
