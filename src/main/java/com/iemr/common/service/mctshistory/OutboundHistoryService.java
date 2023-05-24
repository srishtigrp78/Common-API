package com.iemr.common.service.mctshistory;

import com.iemr.common.utils.exception.IEMRException;

public interface OutboundHistoryService {


	/**
	 * this method define to get previous history of the call
	 * @param request
	 * @return
	 * @throws IEMRException 
	 */
	String getCallHistory(String request) throws IEMRException;

	String getMctsCallResponse(String request) throws IEMRException;

}
