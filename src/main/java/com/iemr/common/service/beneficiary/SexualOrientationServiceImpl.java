package com.iemr.common.service.beneficiary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.beneficiary.SexualOrientation;
import com.iemr.common.repository.userbeneficiarydata.SexualOrientationRepository;

@Service
public class SexualOrientationServiceImpl implements SexualOrientationService {
	private SexualOrientationRepository sexualOrientationRepository;

	@Autowired
	public void setDirectoryRepository(SexualOrientationRepository sexualOrientationRepository) {
		this.sexualOrientationRepository = sexualOrientationRepository;
	}

	@Override
	public List<SexualOrientation> getSexualOrientations() {
		ArrayList<SexualOrientation> sexualOrientations = new ArrayList<SexualOrientation>();
		Set<Objects[]> sexualOrientationResult = sexualOrientationRepository.findAciveOrientations();
		for (Object[] objects : sexualOrientationResult) {
			if (objects != null && objects.length == 2) {
				sexualOrientations.add(new SexualOrientation((Short) objects[0], (String) objects[1]));
			}
		}
		return sexualOrientations;
	}
}
