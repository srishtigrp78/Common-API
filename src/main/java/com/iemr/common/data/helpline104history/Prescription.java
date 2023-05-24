package com.iemr.common.data.helpline104history;

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
@Table(name = "t_104prescription")
public class Prescription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	public Long prescriptionID;
	
	@Expose
	private Long beneficiaryRegID;

	@Expose
	private String diagnosisProvided;

	@Expose
	private String remarks;
	
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;

}
