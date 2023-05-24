package com.iemr.common.service.beneficiary;

import java.util.List;

import com.iemr.common.data.beneficiary.BeneficiaryOccupation;

public interface BeneficiaryOccupationService {
	List<BeneficiaryOccupation> getActiveOccupations();
}
