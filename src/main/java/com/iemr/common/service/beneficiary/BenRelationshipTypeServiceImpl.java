package com.iemr.common.service.beneficiary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.repository.beneficiary.BeneficiaryRelationshipTypeRepository;
@Service
public class BenRelationshipTypeServiceImpl implements BenRelationshipTypeService {

	private BeneficiaryRelationshipTypeRepository beneficiaryRelationshipTypeRepository;

	@Autowired
	public void setBeneficiaryRelationshipTypeRepository(
			BeneficiaryRelationshipTypeRepository beneficiaryRelationshipTypeRepository) {
		this.beneficiaryRelationshipTypeRepository = beneficiaryRelationshipTypeRepository;
	}

	@Override
	public List<BenRelationshipType> getActiveRelationshipTypes() {
		List<BenRelationshipType> benRelationshipTypes = new ArrayList<BenRelationshipType>();
		Set<Objects[]> resultSet = beneficiaryRelationshipTypeRepository.getActiveRelationships();
		for (Object[] object : resultSet) {
			if (object != null && object.length >= 2) {
				benRelationshipTypes.add(new BenRelationshipType((Integer) object[0], (String) object[1], false));
			}
		}
		return benRelationshipTypes;
	}

}
