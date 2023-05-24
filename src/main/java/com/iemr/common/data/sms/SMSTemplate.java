package com.iemr.common.data.sms;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_smstemplate")
@Data
public class SMSTemplate
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SMSTemplateID")
	Integer smsTemplateID;
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="SMSTemplateID", insertable=false, updatable=false)
	List<SMSParametersMap> smsParameterMaps;
	@Column(name = "SMSTemplateName")
	String smsTemplateName;
	@Column(name = "SMSTemplate")
	String smsTemplate;
	@Column(name = "SMSSenderName")
	String smsSenderID;
	@Column(name = "SMSTypeID")
	Integer smsTypeID;
	@OneToOne
	@JoinColumn(name = "SMSTypeID", insertable = false, updatable = false)
	SMSType smsType;
	@Column(name = "ProviderServiceMapID")
	Integer providerServiceMapID;
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
