package com.iemr.common.data.beneficiary;

import java.sql.Timestamp;
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
@Table(name = "m_phonetype")
@Data
public class PhoneType
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PhoneTypeID")
	@Expose
	private Integer phoneTypeID;

	@Transient
	private Set<BenPhoneMap> benPhoneMap;

	@Column(name = "PhoneType")
	private String phoneType;
	@Column(name = "deleted", insertable = false, updatable = true)
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

//	public PhoneType()
//	{
//	}

	public PhoneType createPhoneType(Integer phoneTypeID, String phoneType, Boolean deleted)
	{
		this.phoneTypeID = phoneTypeID;
		this.phoneType = phoneType;
		this.deleted = deleted;
		return this;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
