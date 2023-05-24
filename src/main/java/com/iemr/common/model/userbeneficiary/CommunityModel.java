package com.iemr.common.model.userbeneficiary;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class CommunityModel
{
	@Expose
	private Integer communityID;
	@Expose
	private String communityType;
	@Expose
	private String communityDesc;

	// public static CommunityModel createCommunityModel(Integer communityID, CommunityRepository communityRepository,
	// CommunityMapper communityMapper)
	// {
	// CommunityModel model = new CommunityModel();
	// model = communityMapper
	// .communityToLoginResponse(communityRepository.findOne(communityID));
	// return model;
	// }
}
