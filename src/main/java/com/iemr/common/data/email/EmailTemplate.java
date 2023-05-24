package com.iemr.common.data.email;

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
@Data
@Table(name="m_emailtemplate")
public class EmailTemplate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmailTemplateID")
	private Integer emailTemplateID;
	
	@Column(name = "EmailTemplateName")
	@Expose
	private String emailTemplateName;
	
	@Column(name = "EmailTemplate")
	@Expose
	private String emailTemplate;
	
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
