package com.iemr.common.utils.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

public class OutputMapper {
	static GsonBuilder builder;
	static GsonBuilder builderWithoutExposeRestriction;


	public OutputMapper() {
		if (builder == null) {
			builder = new GsonBuilder();
			builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			builder.excludeFieldsWithoutExposeAnnotation();
			builder.setLongSerializationPolicy(LongSerializationPolicy.STRING);
			builder.serializeNulls();
		}
		if (builderWithoutExposeRestriction == null) {
			builderWithoutExposeRestriction = new GsonBuilder();
			builderWithoutExposeRestriction.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			builder.setLongSerializationPolicy(LongSerializationPolicy.STRING);
			builderWithoutExposeRestriction.serializeNulls();
		}
	}

	public static Gson gson() {
		return builder.create();
	}
	
	public static Gson gsonWithoutExposeRestriction() {
		return builderWithoutExposeRestriction.create();
	}
}