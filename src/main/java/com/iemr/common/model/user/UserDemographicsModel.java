package com.iemr.common.model.user;

import com.iemr.common.model.userbeneficiary.CityModel;
import com.iemr.common.model.userbeneficiary.CommunityModel;
import com.iemr.common.model.userbeneficiary.CountryModel;
import com.iemr.common.model.userbeneficiary.ReligionModel;
import com.iemr.common.model.userbeneficiary.StateModel;

import lombok.Data;

public @Data class UserDemographicsModel
{
	private Integer demographicID;
	private Integer userID;
	private UserModel user;
	private String fathersName;
	private String mothersName;
	private Integer communityID;
	private CommunityModel community;
	private Integer religionID;
	private ReligionModel m_religion;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String addressLine4;
	private String addressLine5;
	private Integer CityID;
	private CityModel m_city;
	private Integer StateID;
	private StateModel m_state;
	private Integer CountryID;
	private CountryModel m_country;
	private String PinCode;
	private Boolean IsPresent;
	private Boolean IsPermanent;
	private Boolean Deleted;
	
	// private String CreatedBy;
	// private Timestamp CreatedDate;
	// private String ModifiedBy;
	// private Timestamp LastModDate;
}
