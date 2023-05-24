package com.iemr.common.model.feedback;

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
@Table(name = "m_authorityemail")
@Data
public class AuthorityEmailID {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AuthorityEmailID")
	private Integer authorityEmailID;
	
	@Column(name = "DistrictID")
	@Expose
	private Integer districtID;
	
	@Column(name = "EmailID")
	@Expose
	private String emailID;
	
	@Column(name = "Deleted")
	private Boolean deleted;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

}
