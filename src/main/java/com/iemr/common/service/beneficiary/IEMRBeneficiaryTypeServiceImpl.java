package com.iemr.common.service.beneficiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.beneficiary.BeneficiaryType;
import com.iemr.common.repository.beneficiary.IEMRBeneficiaryTypeRepository;

@Service
public class IEMRBeneficiaryTypeServiceImpl implements IEMRBeneficiaryTypeService{

	@Autowired
	private IEMRBeneficiaryTypeRepository iemrBeneficiaryTypeRepository;
	
	@Override
	public BeneficiaryType addRelation(BeneficiaryType i_beneficiaryType) {
		return iemrBeneficiaryTypeRepository.save(i_beneficiaryType);
	}

	@Override
	public Iterable<BeneficiaryType> getRelations() {
		return iemrBeneficiaryTypeRepository.findAll();
	}
	
}
