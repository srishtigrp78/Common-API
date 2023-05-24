package com.iemr.common.service.mctshistory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.mctshistory.MctsCallResponseDetail;
import com.iemr.common.data.mctshistory.MctsOutboundCallDetail;
import com.iemr.common.repository.mctshistory.OutboundHistoryRepository;
import com.iemr.common.repository.mctshistory.OutboundResponseRepository;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;

@Service
public class OutboundHistoryServiceImpl implements OutboundHistoryService {

	private OutboundHistoryRepository outboundHistoryRepository;

	/**
	 * @param outboundHistoryRepository the outboundHistoryRepository to set
	 */
	@Autowired
	public void setOutboundHistoryRepository(OutboundHistoryRepository outboundHistoryRepository) {
		this.outboundHistoryRepository = outboundHistoryRepository;
	}

	private OutboundResponseRepository outboundResponseRepository;
	/**
	 * @param outboundResponseRepository the outboundResponseRepository to set
	 */
	@Autowired
	public void setOutboundResponseRepository(OutboundResponseRepository outboundResponseRepository) {
		this.outboundResponseRepository = outboundResponseRepository;
	}
	
	private InputMapper inputMapper = new InputMapper();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iemr.mcts.services.agent.MctsOutboundCallDeatilService#getCallHistory
	 * (java.lang.String)
	 */
	@Override
	public String getCallHistory(String request) throws IEMRException {

		List<MctsOutboundCallDetail> mctsOutboundCallDetails = new ArrayList<MctsOutboundCallDetail>();
		MctsOutboundCallDetail callDetail = inputMapper.gson().fromJson(request, MctsOutboundCallDetail.class);

			mctsOutboundCallDetails = outboundHistoryRepository.getCallHistory(callDetail.getBeneficiaryRegID());
		return mctsOutboundCallDetails.toString();
	}
	
	@Override
	public String getMctsCallResponse(String request) throws IEMRException {

		MctsOutboundCallDetail callDetail = inputMapper.gson().fromJson(request, MctsOutboundCallDetail.class);
		List<MctsCallResponseDetail> callResponseDetails = new ArrayList<MctsCallResponseDetail>();
		callResponseDetails = outboundResponseRepository.getMctsCallResponse(callDetail.getCallDetailID());
		return callResponseDetails.toString();
	}


}
