package com.iemr.common.data.sms;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_smsparameter")
@Data
public class SMSParameters
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SMSParameterID")
	Integer smsParameterID;
	@Column(name = "SMSParamName")
	String smsParameterName;
	@Column(name = "SMSParamSource")
	String smsParameterType;
	@Column(name = "DataClassName")
	String dataClassName;
	@Column(name = "DataVariableName")
	String dataName;
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
	@Column(name = "ServiceID", insertable = false, updatable = false)
	Integer serviceID;

	@Override
	public String toString()
	{
		return OutputMapper.gsonWithoutExposeRestriction().toJson(this);
	}
}
