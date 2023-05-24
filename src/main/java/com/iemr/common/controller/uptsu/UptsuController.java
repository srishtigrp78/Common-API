package com.iemr.common.controller.uptsu;

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

import com.iemr.common.service.uptsu.UptsuService;
import com.iemr.common.utils.response.OutputResponse;

@RequestMapping({ "/uptsu" })
@RestController
public class UptsuController {

	@Autowired
	private UptsuService uptsuService;
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@CrossOrigin
	@RequestMapping(value = "/get/facilityMaster/{providerServiceMapID}/{blockName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getFacility(@PathVariable Integer providerServiceMapID, @PathVariable String blockName) {
		OutputResponse response = new OutputResponse();
		logger.info("getFacility request ");
		try {

			response.setResponse(uptsuService.getFacility(providerServiceMapID, blockName));
		} catch (Exception e) {
			logger.info("getFacility failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin
	@RequestMapping(value = "/save/appointment-details", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String saveAppointmentDetails(@RequestBody String request, @RequestHeader(value = "Authorization") String Authorization) {
		OutputResponse response = new OutputResponse();

		try {

			response.setResponse(uptsuService.saveAppointmentDetails(request, Authorization));
		} catch (Exception e) {

			response.setError(5000, e.getLocalizedMessage());
		}

		return response.toString();
	}

}
