package com.lab_mngt.services;

import com.lab_mngt.dao.AddLabRequestDao;

import com.lab_mngt.model.LabRequestModel;

public class AddLabReleaseService {
	public int insert(LabRequestModel req)

	{
         System.out.println("im at com.lab_mngt.dao.AddLabRequestDao. AddLabReleaseService. insert");
		return new AddLabRequestDao().insertRelease(req);

	}

}
