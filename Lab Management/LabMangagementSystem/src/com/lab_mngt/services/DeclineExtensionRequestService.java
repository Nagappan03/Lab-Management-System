package com.lab_mngt.services;

import com.lab_mngt.dao.DeclineExtensionRequestDao;
import com.lab_mngt.model.LabRequestModel;

public class DeclineExtensionRequestService {
	int result = 0;

	public int extension(LabRequestModel req)

	{

		return new DeclineExtensionRequestDao().decline(req);

	}
}
