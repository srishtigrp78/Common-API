package com.iemr.common.data.userbeneficiarydata;

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
@Table(name = "M_Religion")
@Data
public class Religion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ReligionID")
	@Expose
	private Integer religionID;

	@Transient
	private Set<BenDemographics> i_bendemographics;

	@Transient
	private Set<UserDemographics> m_userdemographics;
	@Column(name = "ReligionType")
	@Expose
	private String religionType;
	@Column(name = "ReligionDesc")
	@Expose
	private String religionDesc;
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

	protected Religion() {
	}

	public Religion(int ReligionID, String ReligionType, String ReligionDesc) {
		this.religionID = Integer.valueOf(ReligionID);
		this.religionType = ReligionType;
		this.religionDesc = ReligionDesc;
	}

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
