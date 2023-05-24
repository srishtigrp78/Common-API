package com.iemr.common.service.userbeneficiarydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.userbeneficiarydata.Gender;
import com.iemr.common.repository.userbeneficiarydata.UserBeneficiaryDataRepository;

/**
 * 
 */
@Service
public class UserBeneficiaryDataServiceImpl implements UserBeneficiaryDataService {
	private UserBeneficiaryDataRepository userBeneficiaryDataRepository;

	@Autowired
	public void setUserBeneficiaryDataRepository(UserBeneficiaryDataRepository userBeneficiaryDataRepository) {
		this.userBeneficiaryDataRepository = userBeneficiaryDataRepository;
	}

	@Override
	public List<Gender> getActiveGender() {
		ArrayList<Gender> genderList = new ArrayList<Gender>();
		Set<Objects[]> queryResult = userBeneficiaryDataRepository.findActiveGenders();
		for (Object[] object : queryResult) {
			if (object != null && object.length == 2) {
				genderList.add(new Gender().getGender((Integer) object[0], (String) object[1]));
			}
		}
		return genderList;
	}

}
