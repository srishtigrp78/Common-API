package com.iemr.common.data.report;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "db_reporting.dim_beneficiary", schema = "db_reporting")
@Data
public class BenDetails implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "Dim_BeneficiaryID", insertable = false, updatable = false)
	private Long dim_BeneficiaryID;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Expose
	@Column(name = "BeneficiaryID")
	private Long beneficiaryID;

	@Expose
	@Column(name = "TitleID")
	private Integer titleID;
	@Expose
	@Column(name = "Title")
	private String title;

	@Expose
	@Column(name = "GenderId")
	private Integer genderID;
	@Expose
	@Column(name = "Gender")
	private String gender;

	@Expose
	@Column(name = "MaritalStatusId")
	private Integer maritalStatusID;
	@Expose
	@Column(name = "MaritalStatus")
	private String maritalStatus;

	@Expose
	@Column(name = "DOB")
	private Timestamp dob;
	@Expose
	@Column(name = "SexualOrientationId")
	private Integer sexualOrientationID;
	@Expose
	@Column(name = "SexualOrientationType")
	private String sexualOrientation;
	@Expose
	@Column(name = "HIVStatus")
	private Integer isHIVPos;

	@Expose
	@Column(name = "educationId")
	private Integer educationID;
	@Expose
	@Column(name = "education")
	private String education;

	@Expose
	@Column(name = "occupationID")
	private Integer occupationID;
	@Expose
	@Column(name = "occupation")
	private String occupation;

	@Expose
	@Column(name = "HealthCareWorkerId")
	private Integer healthcareWorkerID;
	@Expose
	@Column(name = "HealthCareWorker")
	private String healthcareWorker;

	@Expose
	@Column(name = "incomeStatus")
	private String incomeStatus;
	@Expose
	@Column(name = "communityId")
	private Integer communityID;
	@Expose
	@Column(name = "community")
	private String community;

	@Expose
	@Column(name = "preferredLanguage")
	private String preferredLanguage;

	@Expose
	@Column(name = "religionId")
	private Integer religionID;
	@Expose
	@Column(name = "religion")
	private String religion;

	@Expose
	@Column(name = "PlaceOfWork")
	private String placeOfWork;

	@Expose
	@Column(name = "PermDistrictId")
	private Integer districtID;
	@Expose
	@Column(name = "PermDistrict")
	private String district;
	@Expose
	@Column(name = "PermStateID")
	private Integer stateID;
	@Expose
	@Column(name = "PermState")
	private String state;

	@Expose
	@Column(name = "PermSubDistrictId")
	private Integer subDistrictID;
	@Expose
	@Column(name = "PermSubDistrict")
	private String subDistrict;
	
	@Expose
	@Column(name = "PermVillageId")
	private Integer permVillageId;
	@Expose
	@Column(name = "PermVillage")
	private String permVillage;

	@Expose
	@Column(name = "CreatedDate")
	private Integer benCreatedDate;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@Column(name = "CreatedBy")
	private String beneficiaryCreatedBy;
	@Expose
	@Column(name = "LoadedBy")
	private String loadedBy;
	@Column(name = "LodadedDate")
	private Timestamp loadDate;


	@Override
	public String toString()
	{
		return OutputMapper.gsonWithoutExposeRestriction().toJson(this);
	}

}
