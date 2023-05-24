package com.iemr.common.service.userbeneficiarydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.beneficiary.BeneficiaryEducation;
import com.iemr.common.repository.beneficiary.EducationRepository;

@Service
public class EducationServiceImpl implements EducationService {
	private EducationRepository educationRepository;

	@Autowired
	public void setEducationServiceImpl(EducationRepository educationRepository) {
		this.educationRepository = educationRepository;
	}

	public List<BeneficiaryEducation> getActiveEducations() {
		List<BeneficiaryEducation> activeEducations = new ArrayList<BeneficiaryEducation>();
		Set<Objects[]> lists = this.educationRepository.findActiveEducations();
		for (Object[] objects : lists) {
			if ((objects != null) && (objects.length > 0)) {
				activeEducations.add(new BeneficiaryEducation(((Long) objects[0]).longValue(), (String) objects[1]));
			}
		}
		return activeEducations;
	}
}
