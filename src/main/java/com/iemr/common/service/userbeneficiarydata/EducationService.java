package com.iemr.common.service.userbeneficiarydata;

import java.util.List;

import com.iemr.common.data.beneficiary.BeneficiaryEducation;

public abstract interface EducationService {
	public abstract List<BeneficiaryEducation> getActiveEducations();
}
