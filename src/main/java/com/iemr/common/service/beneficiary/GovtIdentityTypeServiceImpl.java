package com.iemr.common.service.beneficiary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.repository.beneficiary.GovtIdentityTypeRepository;

@Service
public class GovtIdentityTypeServiceImpl implements GovtIdentityTypeService
{

	private GovtIdentityTypeRepository govtIdentityTypeRepository;

	@Autowired
	public void setBeneficiaryOccupationRepository(GovtIdentityTypeRepository govtIdentityTypeRepository)
	{
		this.govtIdentityTypeRepository = govtIdentityTypeRepository;
	}

	@Override
	public List<GovtIdentityType> getActiveIDTypes()
	{
		List<GovtIdentityType> govtIdentityTypes = new ArrayList<GovtIdentityType>();
		Set<Objects[]> resultSet = govtIdentityTypeRepository.getActiveIDTypes();
		for (Object[] object : resultSet)
		{
			if (object != null && object.length >= 3)
			{
				govtIdentityTypes.add(new GovtIdentityType().getConstructor((Integer) object[0], (String) object[1], (Boolean) object[2]));

			}
		}
		return govtIdentityTypes;
	}

}
