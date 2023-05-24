package com.iemr.common.data.beneficiary;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.dto.identity.BenIdentityDTO;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_govtidentitytype")
@Data
public class GovtIdentityType
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GovtIdentityTypeID")
	@Expose
	private Integer govtIdentityTypeID;

	@Transient
	private List<Beneficiary> i_Beneficiaries;

	@Column(name = "IdentityType")
	@Expose
	private String identityType;

	@Column(name = "IsGovtID")
	@Expose
	private Boolean isGovtID;

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

	public GovtIdentityType getDefaultConstructor()
	{
		return this;
	}

	public GovtIdentityType getConstructor(Integer govtIdentityTypeID, String identityType, Boolean isGovID)
	{
		this.identityType = identityType;
		this.govtIdentityTypeID = govtIdentityTypeID;
		this.isGovtID = isGovID;
		return this;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

}
