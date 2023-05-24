package com.iemr.common.model.beneficiary;

import java.sql.Timestamp;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class BeneficiaryGenModel {
	
	@Expose
	private Long benRegId;
	
	@Expose
	private Long beneficiaryId;
	
	@Expose
	private Timestamp createdDate;
	
	@Expose
	private String createdBy;
	
	@Override
	public String toString() {

		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().toJson(this);
	}
}
