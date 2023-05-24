package com.iemr.common.data.users;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.data.location.CityDetails;
import com.iemr.common.data.location.Country;
import com.iemr.common.data.location.States;
import com.iemr.common.data.userbeneficiarydata.Community;
import com.iemr.common.data.userbeneficiarydata.Religion;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
@Entity
@Table(name = "M_UserDemographics")
public class UserDemographics {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private Integer DemographicID;

	@Expose
	private Integer UserID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(unique = true, insertable = false, referencedColumnName = "UserID")
	@JsonIgnore
	@Expose
	private User m_user;

	@Expose
	private String FathersName;
	@Expose
	private String MothersName;

	@Expose
	private Integer CommunityID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(unique = true, insertable = false, referencedColumnName = "CommunityID")
	@JsonIgnore
	@Expose
	private Community m_community;

	@Expose
	private Integer ReligionID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(unique = true, insertable = false, referencedColumnName = "ReligionID")
	@JsonIgnore
	@Expose
	private Religion m_religion;

	@Expose
	private String AddressLine1;
	@Expose
	private String AddressLine2;
	@Expose
	private String AddressLine3;
	@Expose
	private String AddressLine4;
	@Expose
	private String AddressLine5;

	@Expose
	private Integer CityID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(unique = true, insertable = false, referencedColumnName = "CityID")
	@JsonIgnore
	@Expose
	private CityDetails m_city;

	@Expose
	private Integer StateID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(unique = true, insertable = false, referencedColumnName = "StateID")
	@JsonIgnore
	@Expose
	private States m_state;

	@Expose
	private Integer CountryID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(unique = true, insertable = false, referencedColumnName = "CountryID")
	@JsonIgnore
	@Expose
	private Country m_country;

	@Expose
	private String PinCode;
	@Expose
	private Boolean IsPresent;
	@Expose
	private Boolean IsPermanent;
	@Expose
	private Boolean Deleted;
	@Expose
	private String CreatedBy;
	private Timestamp CreatedDate;
	private String ModifiedBy;
	private Timestamp LastModDate;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	protected UserDemographics() {
	}

	protected UserDemographics(int DemographicID, int UserID, String FathersName, String MothersName, int CommunityID,
			int ReligionID, String AddressLine1, String AddressLine2, String AddressLine3, String AddressLine4,
			String AddressLine5, int CityID, int StateID, int CountryID, String PinCode, Boolean IsPresent,
			Boolean IsPermanent, Boolean Deleted) {
		this.DemographicID = Integer.valueOf(DemographicID);
		this.UserID = Integer.valueOf(UserID);
		this.FathersName = FathersName;
		this.MothersName = MothersName;
		this.CommunityID = Integer.valueOf(CommunityID);
		this.m_community = new Community().getCommunity(this.CommunityID.intValue(), "");
		this.ReligionID = Integer.valueOf(ReligionID);
		this.m_religion = new Religion(this.ReligionID.intValue(), "", "");
		this.AddressLine1 = AddressLine1;
		this.AddressLine2 = AddressLine2;
		this.AddressLine3 = AddressLine3;
		this.AddressLine4 = AddressLine4;
		this.AddressLine5 = AddressLine5;
		this.CityID = Integer.valueOf(CityID);
		this.m_city = new CityDetails(Integer.valueOf(CityID), "");
		this.StateID = Integer.valueOf(StateID);
		this.m_state = new States();
		this.m_state = this.m_state.getStates(StateID, "");
		this.CountryID = Integer.valueOf(CountryID);
		this.m_country = new Country();
		m_country = m_country.createCountry(CountryID, "");
		this.PinCode = PinCode;
		this.IsPresent = IsPresent;
		this.IsPermanent = IsPermanent;
		this.Deleted = Deleted;
	}

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
