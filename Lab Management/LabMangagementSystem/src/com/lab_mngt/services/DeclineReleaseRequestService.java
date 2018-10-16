package com.lab_mngt.services;

import com.lab_mngt.dao.DeclineReleaseRequestDao;
import com.lab_mngt.model.LabRequestModel;

public class DeclineReleaseRequestService {

	int result = 0;

	public int release(LabRequestModel req)

	{

		return new DeclineReleaseRequestDao().decline(req);

	}
}

