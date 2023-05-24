package com.iemr.common.service.userbeneficiarydata;

import java.util.List;

import com.iemr.common.data.userbeneficiarydata.Religion;

public abstract interface RelegionService {
	public abstract List<Religion> getActiveReligions();
}
