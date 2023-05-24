package com.iemr.common.utils.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.ExclusionStrategy;
import com.google.gson.GsonBuilder;
import com.iemr.common.utils.exception.IEMRException;

/**
 * @author VI314759
 *
 */
@Service
public class InputMapper
{
	static GsonBuilder builder;
	ExclusionStrategy strategy;
	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	public InputMapper()
	{
		if (builder == null)
		{
			builder = new GsonBuilder();
			builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		}
	}

	/**
	 * @return
	 */
	public static InputMapper gson()
	{
		return new InputMapper();
	}

	/**
	 * @param json
	 * @param classOfT
	 * @return
	 * @throws IEMRException
	 */
	public <T> T fromJson(String json, Class<T> classOfT)
	{
		return builder.create().fromJson(json, classOfT);
	}
}