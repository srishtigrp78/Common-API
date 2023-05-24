package com.iemr.common.model.user;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class TitleModel
{
	@Expose
	private Integer titleID;
	// private List<UserModel> m_user;
	// private List<BeneficiaryModel> i_beneficiary;
	@Expose
	private String titleName;
	@Expose
	private String titleDesc;
	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;

	// public static TitleModel createTitle(Integer titleID, TitleRepository titleRepository, TitleMapper titleMapper)
	// {
	// TitleModel titleModel = new TitleModel();
	// if (titleID != null)
	// {
	// titleModel = titleMapper.titleToResponse(titleRepository.findTitlesByID(titleID));
	// }
	// return titleModel;
	// }
}
