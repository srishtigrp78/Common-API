package com.iemr.common.data.helpline104history;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name="M_BloodGroup")
public class M_BloodGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bloodGroupID;
	private String bloodGroup;
	private String bloodGroupDesc;
	private Boolean deleted;
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date lastModDate;
	
	public M_BloodGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public M_BloodGroup(Integer bloodGroupID, String bloodGroup, String bloodGroupDesc) {
		super();
		this.bloodGroupID = bloodGroupID;
		this.bloodGroup = bloodGroup;
		this.bloodGroupDesc = bloodGroupDesc;
	}
	
	public String toString() {
		return new Gson().toJson(this);
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getBloodGroupDesc() {
		return bloodGroupDesc;
	}

	public void setBloodGroupDesc(String bloodGroupDesc) {
		this.bloodGroupDesc = bloodGroupDesc;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Date lastModDate) {
		this.lastModDate = lastModDate;
	}

	public Integer getBloodGroupID() {
		return bloodGroupID;
	}
}
