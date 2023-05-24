package com.iemr.common.service.beneficiary;

import java.util.List;

import com.iemr.common.data.beneficiary.GovtIdentityType;

public interface GovtIdentityTypeService
{
	List<GovtIdentityType> getActiveIDTypes();
}
