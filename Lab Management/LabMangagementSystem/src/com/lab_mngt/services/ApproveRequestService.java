package com.lab_mngt.services;

import com.lab_mngt.dao.ApproveRequestDao;

import com.lab_mngt.model.LabRequestModel;


public class ApproveRequestService {
	int result = 0;

	public int approve(LabRequestModel req)

	{

		return new ApproveRequestDao().approve(req);

	}
}
