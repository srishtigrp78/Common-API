package com.iemr.common.controller.honeywell;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.service.honeywell.HoneywellService;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;
@CrossOrigin
@RequestMapping({ "/honeywell" })
@RestController
public class HoneywellController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	InputMapper inputMapper = new InputMapper();
	@Autowired
	private HoneywellService honeywellService;
	@CrossOrigin
	@RequestMapping(value = "/realtimeDistrictDistribution", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getRealtimeDistrictWiseCallReport()
	{
		OutputResponse response = new OutputResponse();
		try
		{
			response.setResponse(honeywellService.getRealtimeDistrictWiseCallReport());
		} catch (Exception e)
		{
			logger.error("getDistrictWiseCallReport failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		return response.toString();
	}
	@CrossOrigin
	@RequestMapping(value = "/districtWiseCallDistribution", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getDistrictWiseCallReport(
			@RequestBody String request, HttpServletRequest httpRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getDistrictWiseCallReport request "+request);
		try
		{
			response.setResponse(honeywellService.getDistrictWiseCallReport(request));
		} catch (Exception e)
		{
			logger.error("getDistrictWiseCallReport failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		return response.toString();
	}

	
	@CrossOrigin
	@RequestMapping(value = "/urban_rural_calls", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getUrbanRuralCallReport(
			@RequestBody String request, HttpServletRequest httpRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getUrbanRuralCallReport request "+request);
		try
		{
			response.setResponse(honeywellService.getUrbanRuralCallReport(request));
		} catch (Exception e)
		{
			logger.error("getUrbanRuralCallReport failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		return response.toString();
	}
	
}
