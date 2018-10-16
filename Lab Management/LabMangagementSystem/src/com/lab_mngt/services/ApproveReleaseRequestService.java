package com.lab_mngt.services;


import com.lab_mngt.dao.ApproveReleaseRequestDao;

import com.lab_mngt.model.LabRequestModel;

public class ApproveReleaseRequestService {

	
		int result = 0;

		public int approve(LabRequestModel req)

		{

			return new ApproveReleaseRequestDao().approve(req);

		}
}
