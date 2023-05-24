package com.iemr.common.service.cti;

import org.json.JSONException;

import com.iemr.common.data.cti.CustomerLanguage;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.response.OutputResponse;

public interface CTIService
{
	String callUrl(String urlRequest);

	OutputResponse addUpdateAgentSkills(String request, String ipAddress) throws JSONException, IEMRException;

	OutputResponse getCampaignSkills(String request, String ipAddress) throws IEMRException, JSONException;

	OutputResponse getAgentState(String request, String ipAddress) throws JSONException, IEMRException;

	OutputResponse getAgentCallStats(String request, String ipAddress) throws IEMRException, JSONException;

	OutputResponse getCampaignNames(String request, String ipAddress) throws IEMRException, JSONException;

	OutputResponse doAgentLogin(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse getLoginKey(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse agentLogout(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse getOnlineAgents(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse callBeneficiary(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse addUpdateUserData(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse getTransferCampaigns(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse getCampaignRoles(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse setCallDisposition(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse createVoiceFile(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse getVoiceFile(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse disconnectCall(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse switchToInbound(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse switchToOutbound(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse unblockNumber(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse blockNumber(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse getAgentIPAddress(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse getAvailableAgentSkills(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse transferCall(String request, String remoteAddr) throws IEMRException, JSONException;

	String getAgentIP(String agentID);

	OutputResponse customerPreferredLanguage(CustomerLanguage custLang, String remoteAddress);

	OutputResponse addAutoDialNumbers(String request, String ipAddress) throws JSONException, IEMRException;

	String callPostUrl(String urlRequest, String Json);

	OutputResponse setAutoDialNumbers(String request, String ipAddress) throws JSONException, IEMRException;

	OutputResponse getIVRSPathDetails(String request, String remoteAddress)throws Exception;

	OutputResponse getVoiceFileNew(String request, String remoteAddr) throws IEMRException, JSONException;	
}
