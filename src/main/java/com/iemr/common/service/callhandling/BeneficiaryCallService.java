package com.iemr.common.service.callhandling;

import java.util.List;

import org.json.JSONException;

import com.iemr.common.data.callhandling.BeneficiaryCall;
import com.iemr.common.data.callhandling.OutboundCallRequest;
import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.model.beneficiary.BeneficiaryCallModel;
import com.iemr.common.model.beneficiary.CallRequestByIDModel;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.response.OutputResponse;

/**
 * @author VI314759
 *
 */
public interface BeneficiaryCallService {

	/**
	 * This will create beneficiary call for the given call ID
	 * 
	 * @param request        - JSONObject in string format that would be needed to
	 *                       create a new call
	 * @param agentIPAddress
	 * @return - This will return BeneficiaryCall of a newly created call
	 * @throws IEMRException
	 */
	BeneficiaryCall createCall(String request, String agentIPAddress) throws IEMRException;

	/**
	 * This will close the call and updates status of call
	 * 
	 * @param beneficiaryCall - JSONObject in string format with benCallID, status,
	 *                        callTypeID to be sent
	 * @param ipAddress
	 * @return - number of calls closed successfully
	 * @throws Exception
	 */
	Integer closeCall(String beneficiaryCall, String ipAddress) throws Exception;

	/**
	 * This will update beneficiary ID in the call
	 * 
	 * @param beneficiaryCall - JSONObject in string format with benCallID,
	 *                        beneficiaryRegID to be sent
	 * @return - number of calls closed successfully
	 * @throws IEMRException
	 */
	Integer updateBeneficiaryIDInCall(String beneficiaryCall) throws IEMRException;

	String outboundCallList(String request, String auth) throws IEMRException;

	String filterCallList(String request, String auth) throws IEMRException;

	String filterCallListWithPagination(String request, String auth) throws IEMRException;

	String outboundAllocation(String request) throws IEMRException;

	String getBlacklistNumbers(String request) throws IEMRException;

	OutputResponse blockPhoneNumber(String request) throws IEMRException;

	OutputResponse unblockPhoneNumber(String request) throws IEMRException;

	String completeOutboundCall(String request) throws IEMRException;

	String unblockBlockedNumbers();

	Integer updateBeneficiaryCallCDIStatus(String beneficiaryCall) throws IEMRException;

	List<BeneficiaryCall> getCallHistoryByCallID(String request) throws IEMRException;

	String outboundCallListByCallID(String request) throws IEMRException;

	String resetOutboundCall(String request) throws IEMRException;

	String outboundCallCount(String request) throws IEMRException, JSONException;

	String nueisanceCallHistory(String request, String string) throws IEMRException, JSONException;

	Integer closeCallV1(String request, String ipAddress) throws Exception;

	BeneficiaryCallModel beneficiaryByCallID(CallRequestByIDModel request, String string) throws IEMRException;

	String updateOutboundCall(String request) throws IEMRException;

	Boolean isAvailed(BeneficiaryCallModel fromJson);

	List<OutboundCallRequest> getBenRequestedOutboundCall(BeneficiaryCallModel fromJson);

	void updateBenCallIdsInPhoneBlock();

	String isAutoPreviewDialing(ProviderServiceMapping m_ProviderServiceMapping);

	String checkAutoPreviewDialing(ProviderServiceMapping m_ProviderServiceMapping);
	
	String CTIFilePath(String request) throws IEMRException;

	String cTIFilePathNew(String request) throws IEMRException;

}
