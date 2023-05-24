package com.iemr.common.mapper.utils;

import org.json.JSONObject;

public class IdentityResponseFormatter {

	public static String getFormattedString(String identityResponse) {
		
		JSONObject jsonObject = new JSONObject(identityResponse);
		JSONObject jsonData = jsonObject.getJSONObject("response");
		return jsonData.getString("data");
	}
}
