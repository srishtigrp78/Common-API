package com.iemr.common.data.users;

import java.sql.Timestamp;

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

@Data
@Entity
@Table(name = "m_User_Signature")
public class EmployeeSignature {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "UserSignatureID")
	private Long userSignatureID;
	@Expose
	@Column(name = "UserID")
	private Long userID;

	@Expose
	@Column(name = "FileName")
	private String fileName;

	@Expose
	@Column(name = "FileType")
	private String fileType;
	
	@Expose
	@Transient
	private String fileContent;

	@Expose
	@Column(name = "Signature")
	private byte[] signature;

	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	public EmployeeSignature() {

	}

	public EmployeeSignature(Long userSignatureID, Long userID, byte[] signature) {
		super();
		this.userSignatureID = userSignatureID;
		this.userID = userID;
		this.signature = signature;
	}

	public EmployeeSignature(Long userID, byte[] signature,String fileType,String fileName) {
		super();
		this.userID = userID;
		this.signature = signature;
		this.fileType = fileType;
		this.fileName = fileName;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

}
