package com.iemr.common.controller.services;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.service.services.Services;
import com.iemr.common.service.services.ServicesImpl;
import com.iemr.common.utils.response.OutputResponse;

@RequestMapping({ "/service" })
@RestController
public class ServiceController
{
	final private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private Services services;

	@Autowired
	public void setServices(ServicesImpl services)
	{
		this.services = services;
	}

	@CrossOrigin()
	@RequestMapping(value = "/serviceList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String serviceList(@RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		logger.info("serviceList request: " + request);
		try
		{
			response.setResponse(services.servicesList().toString());
		} catch (Exception e)
		{
			logger.error("serviceList failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("serviceList response: " + response.toString());
		return response.toString();
	}
}
