package com.iemr.common.data.nhm_dashboard;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
@Entity
@Table(name = "t_abandonsummary")
public class AbandonCallSummary {

	@Id
	@GeneratedValue

	@Expose
	@Column(name = "id", insertable = false)
	private Long id;
	@Expose
	@Column(name = "CustomerPhoneNumber")
	private String customerPhoneNumber;
	@Expose
	@Column(name = "UniqueID")
	private String uniqueId;
	@Expose
	@Column(name = "QueueEnterTime")
	private Timestamp queueEnterTime;
	@Expose
	@Column(name = "QueueTime")
	private Integer queueTime;
	@Expose
	@Column(name = "DIDNumber")
	private Integer didNumber;
	@Expose
	@Column(name = "Skills")
	private String skills;
	@Expose
	@Column(name = "CampaignName")
	private String campaignName;
	@Expose
	@Column(name = "RedialFlag")
	private String redicalFlag;
	@Expose
	@Column(name = "CallType")
	private String callType;
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "Processed", insertable = false)
	private String processed;
	@Expose
	@Column(name = "CreatedBy", updatable = false)
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Expose
	@Column(name = "ModifiedBy", insertable = false, updatable = true)
	private String modifiedBy;
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

}
