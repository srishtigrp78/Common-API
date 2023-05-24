package com.iemr.common.data.feedback;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_feedbackstatus")
@Data
public class FeedbackStatus
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FeedbackStatusID")
	@Expose
	private Integer feedbackStatusID;
	@Column(name = "FeedbackStatus")
	@Expose
	private String feedbackStatus;
	@Column(name = "FeedbackStatusDesc")
	@Expose
	private String feedbackStatusDesc;
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

	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;

	@OneToMany(mappedBy = "feedbackStatus", fetch = FetchType.LAZY)
	@Transient
	private Set<FeedbackDetails> feedbackDetails;

	public FeedbackStatus()
	{
	}

	public Integer getFeedbackStatusID()
	{
		return feedbackStatusID;
	}

	public void setFeedbackStatusID(Integer feedbackStatusID)
	{
		this.feedbackStatusID = feedbackStatusID;
	}

	public String getFeedbackStatus()
	{
		return feedbackStatus;
	}

	public void setFeedbackStatus(String feedbackStatus)
	{
		this.feedbackStatus = feedbackStatus;
	}

	public String getFeedbackStatusDesc()
	{
		return feedbackStatusDesc;
	}

	public void setFeedbackStatusDesc(String feedbackStatusDesc)
	{
		this.feedbackStatusDesc = feedbackStatusDesc;
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

	public Set<FeedbackDetails> getFeedback()
	{
		return feedbackDetails;
	}

	public void setFeedback(Set<FeedbackDetails> feedback)
	{
		feedbackDetails = feedback;
	}

	public FeedbackStatus(Integer feedbackStatusID, String feedbackStatus, String feedbackStatusDesc)
	{
		this.feedbackStatusID = feedbackStatusID;
		this.feedbackStatus = feedbackStatus;
		this.feedbackStatusDesc = feedbackStatusDesc;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
