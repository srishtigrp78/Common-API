package com.iemr.common.service.userbeneficiarydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.userbeneficiarydata.Community;
import com.iemr.common.repository.beneficiary.CommunityRepository;

@Service
public class CommunityServiceImpl implements CommunityService
{
	private CommunityRepository communityRepository;

	@Autowired
	public void setCommunityServiceImpl(CommunityRepository communityRepository)
	{
		this.communityRepository = communityRepository;
	}

	public List<Community> getActiveCommunities()
	{
		List<Community> communitiesList = new ArrayList<Community>();
		Set<Objects[]> queryReult = communityRepository.findAciveCommunities();
		for (Object[] objects : queryReult)
		{
			if (objects != null && objects.length == 2)
			{
				communitiesList.add(new Community().getCommunity((Integer) objects[0], (String) objects[1]));
			}
		}
		return communitiesList;
	}
}
