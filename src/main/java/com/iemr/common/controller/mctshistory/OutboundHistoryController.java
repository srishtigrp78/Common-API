package com.iemr.common.controller.mctshistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.service.mctshistory.OutboundHistoryService;
import com.iemr.common.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value="/mctsOutboundHistoryController")
public class OutboundHistoryController {

	
	private OutboundHistoryService outboundHistoryService;
	
	/**
	 * @param outboundHistoryService the outboundHistoryService to set
	 */
	@Autowired
	public void setOutboundHistoryService(OutboundHistoryService outboundHistoryService) {
		this.outboundHistoryService = outboundHistoryService;
	}

	/**
	 * api for reading call history
	 * @param request
	 * @return String count of allocated calls
	 */
	@CrossOrigin()
	@RequestMapping(value="/getMctsCallHistory", method = RequestMethod.POST, headers = "Authorization")
	public String getCallHistory(@ApiParam("{\"beneficiaryRegID\":\"Long\"}") @RequestBody String request){
	
		OutputResponse response  = new OutputResponse();
		try{
			
			response.setResponse(outboundHistoryService.getCallHistory(request));
		}catch (Exception e) {
			
			response.setError(e);
		}
		return response.toStringWithSerialization(); 
	}
	
	/**
	 * api for reading call response
	 * @param request
	 * @return String count of allocated calls
	 */
	@CrossOrigin()
	@RequestMapping(value = "/getMctsCallResponse", method = RequestMethod.POST, headers = "Authorization")
	public String getMctsCallResponse(@ApiParam("{\"callDetailID\":\"Long\"}") @RequestBody String request) {

		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(outboundHistoryService.getMctsCallResponse(request));
		} catch (Exception e) {

			response.setError(e);
		}
		return response.toString();
	}


}
