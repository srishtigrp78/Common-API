package com.iemr.common.data.beneficiary;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_Beneficiaryeducation")
@Data
public class BeneficiaryEducation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EducationID")
	@Expose
	private Long educationID;

	@Transient
	private Set<BenDemographics> i_BenDemographics;

	@Column(name = "EducationType")
	@Expose
	private String educationType;
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	protected BeneficiaryEducation() {
	}

	public BeneficiaryEducation(long educationID, String educationType) {
		this.educationID = Long.valueOf(educationID);
		this.educationType = educationType;
	}

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
