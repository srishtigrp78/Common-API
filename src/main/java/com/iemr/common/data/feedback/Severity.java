package com.iemr.common.data.feedback;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "m_severity")
@Data
public class Severity
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SeverityID")
	private Integer severityID;
	@Column(name = "SeverityTypeName")
	private String severityTypeName;
	@Column(name = "SeverityDesc")
	private String severityDesc;
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Column(name = "CreatedBy")
	private String createdBy;
	@Column(name = "CreatedDate")
	private Timestamp createdDate;
	@Column(name = "ModifiedB")
	private String modifiedBy;
	@Column(name = "LastModDate")
	private Timestamp lastModDate;

	@OneToOne(mappedBy = "severity")
	private FeedbackDetails Feedback;

	public Severity()
	{
	}

	public Integer getSeverityID()
	{
		return severityID;
	}

	public void setSeverityID(Integer severityID)
	{
		this.severityID = severityID;
	}

	public String getSeverityTypeName()
	{
		return severityTypeName;
	}

	public void setSeverityTypeName(String severityTypeName)
	{
		this.severityTypeName = severityTypeName;
	}

	public String getSeverityDesc()
	{
		return severityDesc;
	}

	public void setSeverityDesc(String severityDesc)
	{
		this.severityDesc = severityDesc;
	}

	public Integer getProviderServiceMapID()
	{
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID)
	{
		this.providerServiceMapID = providerServiceMapID;
	}

	public Boolean getDeleted()
	{
		return deleted;
	}

	public void setDeleted(Boolean deleted)
	{
		this.deleted = deleted;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		this.createdDate = createdDate;
	}

	public String getModifiedBy()
	{
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy)
	{
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate()
	{
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate)
	{
		this.lastModDate = lastModDate;
	}

	public FeedbackDetails getFeedback()
	{
		return Feedback;
	}

	public void setFeedback(FeedbackDetails feedback)
	{
		Feedback = feedback;
	}

}
