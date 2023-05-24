package com.iemr.common.controller.language;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.service.userbeneficiarydata.LanguageService;
import com.iemr.common.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@RequestMapping({ "/beneficiary" })
@RestController
public class LanguageController
{
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	LanguageService languageService;

	@Autowired
	public void setLanguageService(LanguageService languageService)
	{
		this.languageService = languageService;
	}

	@CrossOrigin()
	@ApiOperation(value = "List of all languages")
	@RequestMapping(value = "/getLanguageList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getLanguageList()
	{
		OutputResponse response = new OutputResponse();
		logger.info("Received get Language List request");
		try
		{
			String languageList = languageService.getActiveLanguages().toString();
			response.setResponse(languageList);
		} catch (Exception e)
		{
			response.setError(e);
			logger.error("get Language List failed with error " + e.getMessage(), e);
		}
		logger.info("get Language List response " + response);
		return response.toString();
	}
}
