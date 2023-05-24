package com.iemr.common.data.helpline104history;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;


@Entity
@Table(name="M_DonationType")
public class M_DonationType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private Integer donationTypeID;
	@Expose
	private String donationType;
	@Expose
	private String donationTypeDesc;
	@Expose
	private Boolean deleted;
	@Expose
	private String createdBy;
	@Expose
	private String modifiedBy;
	
	public M_DonationType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public M_DonationType(Integer donationTypeID, String donationType, String donationTypeDesc) {
		super();
		this.donationTypeID = donationTypeID;
		this.donationType = donationType;
		this.donationTypeDesc = donationTypeDesc;
	}
	public String getDonationType() {
		return donationType;
	}
	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}
	public String getDonationTypeDesc() {
		return donationTypeDesc;
	}
	public void setDonationTypeDesc(String donationTypeDesc) {
		this.donationTypeDesc = donationTypeDesc;
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
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Integer getDonationTypeID() {
		return donationTypeID;
	}
	
	/*
	public String toString() {
		return new Gson().toJson(this);
	} */
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
