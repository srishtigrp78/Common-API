package com.iemr.common.notification.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

public final class OutputMapper {
	private static GsonBuilder builder;
	private static OutputMapper instance = null;
	
	private OutputMapper() {
		builder = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		builder.setLongSerializationPolicy(LongSerializationPolicy.STRING);
				//.excludeFieldsWithoutExposeAnnotation()
//				.serializeNulls();
	}
	
	public static OutputMapper getInstance() {
		if(instance == null) {
			instance = new OutputMapper();
		}
		
		return instance;
	}
	
	public Gson gson() {
		return builder.create();
	}
}
