package com.iemr.common.controller.lonic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.iemr.common.data.lonic.LonicDescription;
import com.iemr.common.service.lonic.LonicService;
import com.iemr.common.utils.response.OutputResponse;
import com.iemr.common.utils.mapper.InputMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RequestMapping(value = "/lonic")
@RestController

public class LonicController {
	private Logger logger = LoggerFactory.getLogger(LonicController.class);
	
	private LonicService lonicService;
	
	@Autowired
	public void setLonicService(LonicService lonicService) {
		this.lonicService = lonicService;
	}
	
	@CrossOrigin
	@ApiOperation(value = "retrives lonic Record list", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/getlonicRecordList", method = RequestMethod.POST, headers = "Authorization")
	public String getLonicRecordList(@ApiParam("{\"term\":\"String\",\"pageNo\":\"Integer\"}") @RequestBody String request) {
		OutputResponse output = new OutputResponse();
		try {

			LonicDescription lonicDescription = InputMapper.gson().fromJson(request, LonicDescription.class);

			logger.info("getLonicRecord request " + lonicDescription.toString());

			
			String lonicList = lonicService.findLonicRecordList(lonicDescription);

			if (lonicList != null)
				output.setResponse(lonicList);
			else
				output.setResponse("No Records Found");

			logger.info("getLonicRecord response: " + output);
		} catch (Exception e) {
			logger.error("getLonicRecord failed with error " + e.getMessage(), e);
			output.setError(e);
		}
		return output.toString();
	}

}
