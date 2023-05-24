package com.iemr.common.data.beneficiary;

import java.sql.Timestamp;
import java.util.List;
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
@Table(name = "m_benrelationshiptype")
@Data
public class BenRelationshipType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BenRelationshipID")
	@Expose
	private Integer benRelationshipID;
	
	@Transient
	@Expose
	private Set<BenPhoneMap> benPhoneMap;

	@Column(name = "BenRelationshipType")
	@Expose
	private String benRelationshipType;
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

	public BenRelationshipType() {

	}

	public BenRelationshipType(Integer benRelationshipID, String benRelationshipType, Boolean deleted) {
		this.benRelationshipID = benRelationshipID;
		this.benRelationshipType = benRelationshipType;
		this.deleted = deleted;
	}

	public Integer getBenRelationshipID() {
		return benRelationshipID;
	}

	public String getBenRelationshipType() {
		return benRelationshipType;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
