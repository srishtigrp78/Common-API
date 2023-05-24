package com.iemr.common.data.feedback;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
@Entity
@Table(name = "t_balVivahComplaints")
public class BalVivahComplaint {
	@Id
	@Expose
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "balVivahComplaintID")
	private Long balVivaComplaintID;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Expose
	@Column(name = "BenCallID")
	private Long benCallID;

	@Expose
	@Column(name = "subjectOfComplaint")
	private String subjectOfComplaint;

	@Expose
	@Column(name = "childName")
	private String childName;

	@Expose
	@Column(name = "childFatherName")
	private String childFatherName;

	@Expose
	@Column(name = "childAge")
	private String childAge;

	@Expose
	@Column(name = "childGender")
	private Short childGender;

	@Expose
	@Column(name = "childStateID")
	private Integer childState;

	@Expose
	@Column(name = "childFatherStateID")
	private String childFatherState;

	@Expose
	@Column(name = "childDistrictID")
	private Integer childDistrict;

	@Expose
	@Column(name = "childFatherDistrictID")
	private String childFatherDistrict;

	@Expose
	@Column(name = "childSubDistrictID")
	private String childSubDistrict;

	@Expose
	@Column(name = "childFatherSubDistrictID")
	private String childFatherSubDistrict;

	@Expose
	@Column(name = "childVillageID")
	private Integer childVillage;

	@Expose
	@Column(name = "childFatherVillageID")
	private String childFatherVillage;

	@Expose
	@Column(name = "marriageDate")
	private Date marriageDate;

	@Expose
	@Column(name = "ComplaintDate")
	private Timestamp ComplaintDate;

	@Expose
	@Column(name = "RequestID")
	private String requestID;

	@Expose
	@Column(name = "providerServiceMapID")
	private Integer providerServiceMapID;

	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;

}
