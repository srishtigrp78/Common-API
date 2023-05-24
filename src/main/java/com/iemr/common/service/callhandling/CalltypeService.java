package com.iemr.common.service.callhandling;

import java.util.List;

import org.json.JSONException;

import com.iemr.common.data.callhandling.CallType;
import com.iemr.common.utils.exception.IEMRException;

public interface CalltypeService {

	// CallType addCalltype(String callType, String remarks, String
	// invalidType);
	//
	// CallType addCalltype(CallType callType);

	List<CallType> getAllCalltypes(String id) throws IEMRException;

	String getAllCalltypesV1(String request) throws JSONException, IEMRException;

	// String updateCalltype(CallType callType);
}
