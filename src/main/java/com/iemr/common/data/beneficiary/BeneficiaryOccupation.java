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
@Table(name = "m_Beneficiaryoccupation")
@Data
public class BeneficiaryOccupation
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OccupationID")
	@Expose
	private Long occupationID;

	@Transient
	private Set<BenDemographics> i_BenDemographics;

	@Column(name = "OccupationType")
	@Expose
	private String occupationType;
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdby;
	@Column(name = "ModifiedBy")
	private String modifiedby;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	public BeneficiaryOccupation getOccupation(Long occupationid, String occupationtype)
	{
		this.occupationID = occupationid;
		this.occupationType = occupationtype;
		return this;
	}

	public BeneficiaryOccupation getOccupation(Long occupationID, String occupationType, Boolean deleted, String createdBy,
			String modifiedBy)
	{
		this.occupationID = occupationID;
		this.occupationType = occupationType;
		this.deleted = deleted;
		this.createdby = createdBy;
		this.modifiedby = modifiedBy;
		return this;
	}

	public Long getOccupationID()
	{
		return this.occupationID;
	}

	public String getOccupationType()
	{
		return this.occupationType;
	}

	public void setOccupationType(String occupationType)
	{
		this.occupationType = occupationType;
	}

	public Boolean getDeleted()
	{
		return this.deleted;
	}

	public void setDeleted(Boolean deleted)
	{
		this.deleted = deleted;
	}

	public String getCreatedBy()
	{
		return this.createdby;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdby = createdBy;
	}

	public String getModifiedBy()
	{
		return this.modifiedby;
	}

	public void setModifiedBy(String modifiedBy)
	{
		this.modifiedby = modifiedBy;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
