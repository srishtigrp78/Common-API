package com.iemr.common.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.dto.identity.BenIdentityDTO;
import com.iemr.common.model.userbeneficiary.BeneficiaryIdentityModel;
import com.iemr.common.model.userbeneficiary.GovtIdentityTypeModel;
import com.iemr.common.repository.beneficiary.GovtIdentityTypeRepository;

public abstract class GovtIdentityTypeDecorator implements GovtIdentityTypeMapper
{
	@Autowired
	GovtIdentityTypeRepository govtIdentityTypeRepository;

	public GovtIdentityTypeModel govtIdentityTypeModelByIDToModel(Integer govtIdentityTypeModelID)
	{
		GovtIdentityTypeModel govtIdentityTypeModel = null;
		if (govtIdentityTypeModelID != null)
		{
			govtIdentityTypeModel = getGovtIdentity(govtIdentityTypeRepository.findOne(govtIdentityTypeModelID));
		}
		return govtIdentityTypeModel;
	}

	@Override
	public List<BeneficiaryIdentityModel> govtIdentityTypeModelsByIDToModel(List<BenIdentityDTO> identityDTOs)
	{
		List<BeneficiaryIdentityModel> identityModels = null;
		if (identityDTOs != null)
		{
			identityModels = new ArrayList<BeneficiaryIdentityModel>();
			for (BenIdentityDTO identityDTO : identityDTOs)
			{
				if (identityDTO.getIdentityNameId() != null)
				{
					BeneficiaryIdentityModel identityModel = new BeneficiaryIdentityModel();
					identityModel.setGovtIdentityNo(identityDTO.getIdentityNo());
					identityModel.setGovtIdentityTypeID(identityDTO.getIdentityNameId());
					identityModel.setBenIdentityId(identityDTO.getBenIdentityId());
					identityModel.setCreatedBy(identityDTO.getCreatedBy());
					identityModel.setDeleted(identityDTO.getDeleted());
					identityModel.setGovtIdentityType(
							getGovtIdentity(govtIdentityTypeRepository.findOne(identityDTO.getIdentityNameId())));
					identityModels.add(identityModel);
				}
			}
		}
		return identityModels;
	}
}
