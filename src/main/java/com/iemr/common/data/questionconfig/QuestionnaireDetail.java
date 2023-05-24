package com.iemr.common.data.questionconfig;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

/**
 * 
 * @author WA875423
 *
 */
@Entity
@Table(name = "m_Questionnaire")
@Data
public class QuestionnaireDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "QuestionID")
	private Long questionID;

	@Expose
	@Column(name = "Question")
	private String question;

	@Expose
	@Column(name = "QuestionDesc")
	private String questionDesc;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "questionTypeID", insertable = false, updatable = false)
	@Expose
	private QuestionTypeDetail questionTypeDetail;

	@Expose
	@Column(name = "AnswerType")
	private String answerType;

	@Expose
	@Column(name = "TriggerFeedback")
	private Boolean triggerFeedback;

	@Expose
	@Column(name = "TriggerFeedbackFor")
	private String triggerFeedbackFor;

	@Column(name = "ProviderServiceMapID")
	@Expose
	private Integer providerServiceMapID;

	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;

	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;

	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;

	@Column(name = "ModifiedBy")
	private Boolean modifiedBy;

	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	/**
	 * Default Constructor
	 */
	public QuestionnaireDetail() {
	}

	/**
	 * constructor with parameters
	 */
	public QuestionnaireDetail(Long questionID, String question, String questionDesc) {

		this.questionID = questionID;
		this.question = question;
		this.questionDesc = questionDesc;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return outputMapper.gson().toJson(this);
	}

}
