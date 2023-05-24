package com.iemr.common.controller.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.iemr.common.data.users.EmployeeSignature;
import com.iemr.common.service.users.EmployeeSignatureServiceImpl;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

@PropertySource("classpath:application.properties")

@RestController
@RequestMapping(value = "/signature1")
public class EmployeeSignatureController {

	@Autowired
	EmployeeSignatureServiceImpl employeeSignatureServiceImpl;

	private InputMapper inputMapper = new InputMapper();

	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@CrossOrigin()
	@RequestMapping(value = "/{userID}", headers = "Authorization", method = { RequestMethod.GET })
	public ResponseEntity<byte[]> fetchFile(@PathVariable("userID") Long userID) throws Exception {
		OutputResponse response = new OutputResponse();
		logger.debug("File download for userID" + userID);

		try {

			EmployeeSignature userSignID = employeeSignatureServiceImpl.fetchSignature(userID);
//			logger.debug("response" + Arrays.toString(userSignID.getSignature()));
//
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(userSignID.getFileType()))
					.header(HttpHeaders.CONTENT_DISPOSITION,
							"inline; filename=\"" + userSignID.getFileName() + "\"")
					.body(userSignID.getSignature());

		} catch (Exception e) {
			logger.error("File download for userID failed with exception " + e.getMessage(), e);
//			throw new Exception("Error while downloading file. Please contact administrator..");

		}

		return ResponseEntity.badRequest().body(new byte[] {});
		/**
		 * sending the response...
		 */

	}
	
	@CrossOrigin()
	@RequestMapping(value = "/getSignClass/{userID}", headers = "Authorization", method = { RequestMethod.GET })
	public String fetchFileFromCentral(@PathVariable("userID") Long userID) throws Exception {
		OutputResponse response = new OutputResponse();
		logger.debug("File download for userID" + userID);

		try {

			EmployeeSignature userSignID = employeeSignatureServiceImpl.fetchSignature(userID);
//			logger.debug("response" + Arrays.toString(userSignID.getSignature()));
//
			if(userSignID != null)			
				response.setResponse(new Gson().toJson(userSignID));
			else
				response.setError(5000,"No record found");

		} catch (Exception e) {
			response.setError(5000,e.getMessage());
			logger.error("File download for userID failed with exception " + e.getMessage(), e);
//			throw new Exception("Error while downloading file. Please contact administrator..");

		}
		return response.toString();
	}
	
	
	@CrossOrigin()
	@RequestMapping(value = "/signexist/{userID}", headers = "Authorization", method = { RequestMethod.GET })
	public String existFile(@PathVariable("userID") Long userID) throws Exception {
		OutputResponse response = new OutputResponse();
		logger.debug("File download for userID" + userID);

		try {

			Boolean userSignID = employeeSignatureServiceImpl.existSignature(userID);
//			logger.debug("response" + Arrays.toString(userSignID.getSignature()));
//
			response.setResponse(userSignID.toString());

		} catch (Exception e) {
			logger.error("File download for userID failed with exception " + e.getMessage(), e);
			response.setError(e);
		}

		/**
		 * sending the response...
		 */
		logger.debug("response" + response);
		return response.toString();
	}
}
