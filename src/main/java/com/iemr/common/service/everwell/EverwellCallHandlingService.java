package com.iemr.common.service.everwell;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.iemr.common.data.everwell.EverwellDetails;
import com.iemr.common.utils.exception.IEMRException;
@Service
public interface EverwellCallHandlingService {
	String outboundCallCount(String request) throws IEMRException, JSONException;
	String outboundAllocation(String request) throws IEMRException;
	String outboundCallList(String request) throws IEMRException;
	String resetOutboundCall(String request) throws IEMRException;
	String saveDetails(String request) throws IEMRException, ParseException;
	String completeOutboundCall(String request) throws IEMRException;
	String updateIncompleteCallStatus(String request) throws IEMRException;
	String getEverwellFeedback(String request) throws IEMRException;
	String outboundCallListWithMobileNumber(String request) throws IEMRException;
    String checkAlreadyCalled(String request) throws IEMRException;
}
