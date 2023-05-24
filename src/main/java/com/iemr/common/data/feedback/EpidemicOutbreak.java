package com.iemr.common.data.feedback;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Entity
@Data
@Table(name = "T_EpidemicOutbreak")
public class EpidemicOutbreak {

	@Id
	@Expose
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long outbreakComplaintID;
	@Expose
	private String requestID;
	@Expose
	@Column(name = "BenCallID")
	private Long benCallID;

	@Expose
	private Long beneficiaryRegID;
	@Expose
	private String natureOfComplaint;
	@Expose
	private Integer totalPeopleAffected;
	@Expose
	private Integer affectedDistrictID;

	@Expose
	private Integer affectedDistrictBlockID;

	@Expose
	private Integer affectedVillageID;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer serviceID;
	@Expose
	private String remarks;
	@Expose
	private Boolean deleted;
	@Expose
	private String createdBy;
	@Expose
	private String modifiedBy;
	@Expose
	@Column(name = "createdDate", insertable = false, updatable = false)
	private Timestamp createdDate;

}
