package com.iemr.common.service.userbeneficiarydata;

import java.util.List;

import com.iemr.common.data.userbeneficiarydata.Status;

public abstract interface StatusService {
	public abstract List<Status> getActiveStatus();
}
