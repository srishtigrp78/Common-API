package com.iemr.common.data.sms;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_smsparametermapping")
@Data
public class SMSParametersMap
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SMSParameterMapID")
	Integer smsParameterMapID;
	@Column(name = "SMSParameterID")
	Integer smsParameterID;
	@OneToOne
	@JoinColumn(name = "SMSParameterID", insertable = false, updatable = false)
	SMSParameters smsParameter;
	@Column(name = "SMSTypeID")
	Integer smsTypeID;
	@OneToOne
	@JoinColumn(name = "SMSTypeID", insertable = false, updatable = false)
	SMSType smsType;
	@Column(name = "SMSTemplateID")
	Integer smsTemplateID;
	@Column(name = "UserParameterName")
	String smsParameterName;
	@Column(name = "Deleted", insertable = false, updatable = true)
	Boolean deleted;
	@Column(name = "CreatedBy", insertable = true, updatable = false)
	String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	Timestamp createdDate;
	@Column(name = "ModifiedBy", insertable = false, updatable = true)
	String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	Timestamp lastModDate;

	@Override
	public String toString()
	{
		return OutputMapper.gsonWithoutExposeRestriction().toJson(this);
	}
}
