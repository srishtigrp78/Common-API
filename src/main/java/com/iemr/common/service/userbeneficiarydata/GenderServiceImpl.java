package com.iemr.common.service.userbeneficiarydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.userbeneficiarydata.Gender;
import com.iemr.common.repository.userbeneficiarydata.GenderRepository;

@Service
public class GenderServiceImpl implements GenderService {
	private GenderRepository genderRepository;

	@Autowired
	public void setGenderServiceImpl(GenderRepository genderRepository) {
		this.genderRepository = genderRepository;
	}

	public List<Gender> getActiveGenders() {
		List<Gender> genderList = new ArrayList<Gender>();
		Set<Objects[]> queryResult =  genderRepository.findAciveGenders();
		for (Object[] objects : queryResult) {
			if (objects!=null && objects.length == 2) {
				genderList.add(new Gender().getGender((Integer)objects[0], (String)objects[1]));
			}
		}
		return genderList;
	}
}
