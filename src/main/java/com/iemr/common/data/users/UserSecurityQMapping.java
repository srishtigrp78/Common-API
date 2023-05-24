package com.iemr.common.data.users;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
// import javax.persistence.Transient;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
@Entity
@Table(name = "m_usersecurityqamapping")
public class UserSecurityQMapping
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private Long UserSecurityQAID;
	@Expose
	private Long UserID;

	@Column(name = "QuestionID")
	@Expose
	private String QuestionID;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "QuestionID", insertable = false, updatable = false)
	@JsonIgnore
	@Expose
	private LoginSecurityQuestions m_LoginSecurityQuestions;

	@Expose
	private String Answers;
	@Expose
	private String MobileNumber;
	@Expose
	private Boolean Deleted;
	@Expose
	private String CreatedBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp CreatedDate;
	private String ModifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp LastModDate;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	protected UserSecurityQMapping()
	{
	}

	public UserSecurityQMapping(Long userSecurityQAID, Long userID, String questionID,
			LoginSecurityQuestions m_LoginSecurityQuestions, String answers, String mobileNumber, Boolean deleted,
			String createdBy, Timestamp createdDate, String modifiedBy, Timestamp lastModDate)
	{
		super();
		UserSecurityQAID = userSecurityQAID;
		UserID = userID;
		QuestionID = questionID;
		this.m_LoginSecurityQuestions = m_LoginSecurityQuestions;
		this.Answers = answers;
		this.MobileNumber = mobileNumber;
		this.Deleted = deleted;
		this.CreatedBy = createdBy;
		this.CreatedDate = createdDate;
		this.ModifiedBy = modifiedBy;
		this.LastModDate = lastModDate;
	}

	public Long getUserSecurityQAID()
	{
		return this.UserSecurityQAID;
	}

	public Long getUserID()
	{
		return this.UserID;
	}

	// public LoginSecurityQuestions getM_LoginSecurityQuestions() {
	// return this.m_LoginSecurityQuestions;
	// }

	public String getAnswers()
	{
		return this.Answers;
	}

	public String getMobileNumber()
	{
		return this.MobileNumber;
	}

	public Boolean getDeleted()
	{
		return this.Deleted;
	}

	public String getCreatedBy()
	{
		return this.CreatedBy;
	}

	public Timestamp getCreatedDate()
	{
		return CreatedDate;
	}

	public String getModifiedBy()
	{
		return this.ModifiedBy;
	}

	public Timestamp getLastModDate()
	{
		return LastModDate;
	}

	public void setUserSecurityQAID(Long userSecurityQAID)
	{
		UserSecurityQAID = userSecurityQAID;
	}

	public void setUserID(Long userID)
	{
		UserID = userID;
	}

	// public void setM_LoginSecurityQuestions(LoginSecurityQuestions m_LoginSecurityQuestions) {
	// this.m_LoginSecurityQuestions = m_LoginSecurityQuestions;
	// }

	public void setAnswers(String answers)
	{
		Answers = answers;
	}

	public void setMobileNumber(String mobileNumber)
	{
		MobileNumber = mobileNumber;
	}

	public void setDeleted(Boolean deleted)
	{
		Deleted = deleted;
	}

	public void setCreatedBy(String createdBy)
	{
		CreatedBy = createdBy;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		CreatedDate = createdDate;
	}

	public void setModifiedBy(String modifiedBy)
	{
		ModifiedBy = modifiedBy;
	}

	public void setLastModDate(Timestamp lastModDate)
	{
		LastModDate = lastModDate;
	}

	public String getQuestionID()
	{
		return QuestionID;
	}

	public void setQuestionID(String questionID)
	{
		QuestionID = questionID;
	}

	@Override
	public String toString()
	{
		return OutputMapper.gson().toJson(this);
	}
}
