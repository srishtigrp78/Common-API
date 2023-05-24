package com.iemr.common.service.userbeneficiarydata;

import java.util.List;

import com.iemr.common.data.userbeneficiarydata.MaritalStatus;

public interface MaritalStatusService {
	List<MaritalStatus> getActiveMaritalStatus();
}
