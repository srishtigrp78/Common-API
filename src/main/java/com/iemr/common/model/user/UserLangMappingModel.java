package com.iemr.common.model.user;

import com.iemr.common.model.userbeneficiary.LanguageModel;

import lombok.Data;

public @Data class UserLangMappingModel
{
	private Integer userLangID;
	private Integer userID;
	// private UserModel m_user;
	private Integer languageID;
	private LanguageModel m_language;
	private Boolean canRead;
	private Boolean canWrite;
	private Boolean canSpeak;
	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
