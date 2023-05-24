package com.iemr.common.data.location;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BenDemographics;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.data.users.UserDemographics;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_country")
@Data
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CountryID")
	@Expose
	private Integer countryID;

	@Transient
	private Set<BenDemographics> i_bendemographics;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m_country")
	@Transient
	private Set<UserDemographics> m_userdemographics;

	@Column(name = "CountryName")
	@Expose
	private String countryName;
	@Column(name = "CountryCode")
	@Expose
	private String countryCode;
	@Column(name = "Continent")
	@Expose
	private String continent;
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	public Country createCountry(Integer countryID, String countryName, String countryCode, String Continent) {
		this.countryID = countryID;
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.continent = Continent;
		return this;
	}

	public Country createCountry(Integer countryID, String countryName) {
		this.countryID = countryID;
		this.countryName = countryName;
		return this;
	}

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
