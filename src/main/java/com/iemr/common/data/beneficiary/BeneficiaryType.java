package com.iemr.common.data.beneficiary;

import java.sql.Timestamp;

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
@Table(name = "I_BeneficiaryType")
@Data
public class BeneficiaryType
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BeneficiaryTypeID")
	@Expose
	private Short beneficiaryTypeID;
	@Column(name = "BeneficiaryType")
	@Expose
	private String beneficiaryType;
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

	public BeneficiaryType()
	{
	}

	public BeneficiaryType(Short beneficiaryTypeID, String beneficiaryType, Boolean deleted, String createdBy,
			Timestamp createdDate, String modifiedBy, Timestamp lastModDate)
	{
		this.beneficiaryTypeID = beneficiaryTypeID;
		this.beneficiaryType = beneficiaryType;
		this.deleted = deleted;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
	}

	public Short getBeneficiaryTypeID()
	{
		return this.beneficiaryTypeID;
	}

	public void setBeneficiaryTypeID(Short beneficiaryTypeID)
	{
		this.beneficiaryTypeID = beneficiaryTypeID;
	}

	public String getBeneficiaryType()
	{
		return this.beneficiaryType;
	}

	public void setBeneficiaryType(String beneficiaryType)
	{
		this.beneficiaryType = beneficiaryType;
	}

	public Boolean isDeleted()
	{
		return this.deleted;
	}

	public void setDeleted(boolean deleted)
	{
		this.deleted = Boolean.valueOf(deleted);
	}

	public String getCreatedBy()
	{
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate()
	{
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		this.createdDate = createdDate;
	}

	public String getModifiedBy()
	{
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy)
	{
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate()
	{
		return this.lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate)
	{
		this.lastModDate = lastModDate;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
