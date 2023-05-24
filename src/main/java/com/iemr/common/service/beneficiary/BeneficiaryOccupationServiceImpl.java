package com.iemr.common.service.beneficiary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.repository.beneficiary.BeneficiaryOccupationRepository;

@Service
public class BeneficiaryOccupationServiceImpl implements BeneficiaryOccupationService {

	private BeneficiaryOccupationRepository beneficiaryOccupationRepository;

	@Autowired
	public void setBeneficiaryOccupationRepository(BeneficiaryOccupationRepository beneficiaryOccupationRepository) {
		this.beneficiaryOccupationRepository = beneficiaryOccupationRepository;
	}

	@Override
	public List<BeneficiaryOccupation> getActiveOccupations() {
		List<BeneficiaryOccupation> benRelationshipTypes = new ArrayList<BeneficiaryOccupation>();
		Set<Objects[]> resultSet = beneficiaryOccupationRepository.getActiveOccupations();
		for (Object[] object : resultSet) {
			if (object != null && object.length >= 2) {
				benRelationshipTypes.add(new BeneficiaryOccupation().getOccupation((Long) object[0], (String) object[1]));
			}
		}
		return benRelationshipTypes;
	}

}
