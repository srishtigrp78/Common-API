package com.iemr.common.model.userbeneficiary;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class GenderModel
{
	@Expose
	private Short genderID;
	@Expose
	private String genderName;

	// public static GenderModel createGender(Integer genderId, GenderRepository genderRepository,
	// GenderMapper genderMapper)
	// {
	// GenderModel genderModel = new GenderModel();
	// if (genderId != null)
	// {
	// genderModel = genderMapper.genderToLoginResponse(genderRepository.findGendersByID(genderId));
	// }
	// return genderModel;
	// }
}
