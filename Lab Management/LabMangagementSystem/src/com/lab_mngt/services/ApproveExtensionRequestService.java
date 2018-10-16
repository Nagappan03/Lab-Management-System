package com.lab_mngt.services;

import com.lab_mngt.dao.ApproveExtensionRequestDao;

import com.lab_mngt.model.LabRequestModel;

public class ApproveExtensionRequestService {

	int result = 0;

	public int approve(LabRequestModel req)

	{

		return new ApproveExtensionRequestDao().approve(req);

	}
}
