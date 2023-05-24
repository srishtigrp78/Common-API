package com.iemr.common.service.beneficiary;

import com.iemr.common.data.beneficiary.BeneficiaryType;

public interface IEMRBeneficiaryTypeService {
	
	BeneficiaryType addRelation(BeneficiaryType i_beneficiaryType);
	
	public Iterable<BeneficiaryType> getRelations();
	
}
