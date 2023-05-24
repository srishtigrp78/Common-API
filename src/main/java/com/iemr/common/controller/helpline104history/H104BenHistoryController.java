package com.iemr.common.controller.helpline104history;


import java.util.ArrayList;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.data.helpline104history.H104BenMedHistory;
import com.iemr.common.service.helpline104history.H104BenHistoryServiceImpl;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping(value = "/beneficiary")
@RestController
public class H104BenHistoryController {
	InputMapper inputMapper = new InputMapper();
	private Logger logger = LoggerFactory.getLogger(H104BenHistoryController.class);
	
	@Autowired
	private H104BenHistoryServiceImpl smpleBenHistoryServiceImpl;
	
	@CrossOrigin
	@ApiOperation(
			value = "retrives cashesheet history",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value = "/get104BenMedHistory", method = RequestMethod.POST, headers = "Authorization")
	public String getBenCaseSheet(@ApiParam(
			value = "{\"beneficiaryRegID\":\"long\"}") @RequestBody String request) {
		OutputResponse output= new OutputResponse();
		try {
			
		H104BenMedHistory smpleBenreq = inputMapper.gson().fromJson(request,
				H104BenMedHistory.class);
		logger.info("getBenCaseSheet request " + smpleBenreq.toString());
		
		
		ArrayList<Objects[]> smpleBenHistory = smpleBenHistoryServiceImpl.geSmpleBenHistory(smpleBenreq.getBeneficiaryRegID());
		output.setResponse(smpleBenHistory.toString());
		logger.info("getBenCaseSheet response: " + output);
		} catch (Exception e) {
			logger.error("getBenCaseSheet failed with error " + e.getMessage(), e);
			output.setError(e);
		}
		return output.toString();
	}
		
	
	
}

