package com.iemr.common.data.report;

import com.iemr.common.utils.mapper.OutputMapper;

public class CTIData {

	OutputMapper mapper = new OutputMapper();
	
	@Override
	public String toString()
	{
		return OutputMapper.gson().toJson(this);
	}
	
	private CTIResponse response;

	public CTIResponse getResponse() {
		return response;
	}

	public void setResponse(CTIResponse response) {
		this.response = response;
	}
	
}
