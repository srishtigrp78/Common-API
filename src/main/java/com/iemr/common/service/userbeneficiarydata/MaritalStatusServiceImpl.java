package com.iemr.common.service.userbeneficiarydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.userbeneficiarydata.MaritalStatus;
import com.iemr.common.repository.userbeneficiarydata.MaritalStatusRepository;

@Service
public class MaritalStatusServiceImpl implements MaritalStatusService
{
	private MaritalStatusRepository maritalStatusRepository;

	@Autowired
	public void setMaritalStatusServiceImpl(MaritalStatusRepository maritalStatusRepository)
	{
		this.maritalStatusRepository = maritalStatusRepository;
	}

	public List<MaritalStatus> getActiveMaritalStatus()
	{
		List<MaritalStatus> genderList = new ArrayList<MaritalStatus>();
		Set<Objects[]> queryResult = maritalStatusRepository.findAciveMaritalStatus();
		for (Object[] objects : queryResult)
		{
			if (objects != null && objects.length == 2)
			{
				MaritalStatus maritalStatus = new MaritalStatus();
				genderList.add(maritalStatus.getMaritalStatus((Integer) objects[0], (String) objects[1]));
			}
		}
		return genderList;
	}
}
