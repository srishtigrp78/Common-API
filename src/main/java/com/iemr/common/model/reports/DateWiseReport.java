package com.iemr.common.model.reports;

import java.sql.Timestamp;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import lombok.Data;
@Data
public class DateWiseReport {
	
	private Timestamp date;
	private Long countOfCalls;
	
	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("MM/dd/yyyy").create().toJson(this);

	}
}
