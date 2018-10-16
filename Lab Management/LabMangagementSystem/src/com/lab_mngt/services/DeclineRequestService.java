package com.lab_mngt.services;


import com.lab_mngt.dao.DeclineLabRequestDao;
import com.lab_mngt.model.LabRequestModel;

public class DeclineRequestService {

	int result = 0;

	public int decline(LabRequestModel req)

	{

		return new DeclineLabRequestDao().decline(req);

	}
}

