package com.iemr.common.data.questionconfig;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

/**
 * Entity class for QuestionType Table
 * 
 * @author WA875423
 *
 */
@Entity
@Table(name = "m_questiontype")
@Data
public class QuestionTypeDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "QuestionTypeID")
	private Long questionTypeID;

	@Expose
	@Column(name = "QuestionType")
	private String questionType;

	@Expose
	@Column(name = "QuestionTypeDesc")
	private String questionTypeDesc;

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "questionTypeDetail")
	private List<QuestionnaireDetail> questionnaireDetails;

	/**
	 * Default Constructor
	 */
	public QuestionTypeDetail() {
	}

	/**
	 * constructor with parameters
	 */
	public QuestionTypeDetail(Long questionTypeID, String questionType, String questionTypeDesc) {

		this.questionTypeID = questionTypeID;
		this.questionType = questionType;
		this.questionTypeDesc = questionTypeDesc;
	}

	private static OutputMapper outputMapper = new OutputMapper();

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
