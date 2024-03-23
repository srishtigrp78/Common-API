package com.iemr.common.controller.customization;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.service.customization.CustomizationService;
import com.iemr.common.utils.response.OutputResponse;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping(value = "/customization")
@RestController
public class CustomizationController {

	@Autowired
	private CustomizationService customizationService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@CrossOrigin()
	@Operation(summary = "Add project")
	@RequestMapping(value = "/addProject", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String addProject(@RequestBody String request,
			@RequestHeader(value = "Authorization") String Authorization) {

		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(customizationService.addProject(request, Authorization));
		} catch (Exception e) {

			response.setError(5000, e.getLocalizedMessage());
		}
		return response.toString();
	}
	
	@CrossOrigin
	@Operation(summary = "Fetch project names")
	@RequestMapping(value = "/get/projectNames/{serviceProviderId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getProjectNames(@PathVariable Integer serviceProviderId) {
		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(customizationService.getProjectNames(serviceProviderId));
		} catch (Exception e) {
			logger.info("getFacility failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}
	
	@CrossOrigin()
	@Operation(summary = "Validate project")
	@RequestMapping(value = "/validateProject", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String validateProject(@RequestBody String request,
			@RequestHeader(value = "Authorization") String Authorization) {

		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(customizationService.validateProject(request, Authorization));
		} catch (Exception e) {

			response.setError(5000, e.getLocalizedMessage());
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@Operation(summary = "Save project to serviceline")
	@RequestMapping(value = "/saveProjectToServiceline", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String saveProjectToServiceline(@RequestBody String request,
			@RequestHeader(value = "Authorization") String Authorization) {

		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(customizationService.saveProjectToServiceline(request, Authorization));
		} catch (Exception e) {

			response.setError(5000, e.getLocalizedMessage());
		}
		return response.toString();
	}
}
