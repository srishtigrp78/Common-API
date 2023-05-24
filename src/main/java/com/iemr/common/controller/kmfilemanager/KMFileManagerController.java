package com.iemr.common.controller.kmfilemanager;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.data.kmfilemanager.KMFileManager;
import com.iemr.common.mapper.utils.InputMapper;
import com.iemr.common.service.kmfilemanager.KMFileManagerService;
import com.iemr.common.service.scheme.SchemeServiceImpl;
import com.iemr.common.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping({ "/kmfilemanager" })
@RestController
public class KMFileManagerController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private KMFileManagerService kmFileManagerService;

	@Autowired
	public void setKmFileManagerService(KMFileManagerService kmFileManagerService) {
		this.kmFileManagerService = kmFileManagerService;
	}

	@Autowired
	private SchemeServiceImpl schemeServiceImpl;

	@CrossOrigin
	@ApiOperation(value = "API will add file sent as string in KM.")
	@RequestMapping(value = "/addFile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	// @Transactional
	public String addFile(
			@ApiParam(value = "{\"fileName\":\"String: name of file\", \"fileExtension:\"String: file extension\", "
					+ "\"providerServiceMapID\":\"Integer: service provider map ID\", "
					+ "userID:\"Integer: user ID of the supervisor\", "
					+ "\"validFrom\":\"Epoch date time: Document validity start time\", "
					+ "\"validUpto\":\"Epoch date time: Document validity end time\", "
					+ "\"fileContent\":\"String: base64encoded binary file content\", "
					+ "\"createdBy\":\"String: username of supervisor\", "
					+ "\"categoryID\":\"Optional: Integer: category ID selected\", "
					+ "\"subCategoryID\":\"Optional: Integer: sub-category ID selected\"}") @RequestBody String addFileRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("add file request is " + addFileRequest);
		try {
			response.setResponse(kmFileManagerService.addKMFile(addFileRequest));
		} catch (Exception e) {
			logger.error("add file failed with exception: " + e.getMessage(), e);
			response.setError(e);
		}
		logger.debug("add file response is " + response.toString());
		logger.info("add file response sent with status code " + response.getStatusCode());
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "API will add file sent as string in KM.")
	@RequestMapping(value = "/getKMFileDownloadURL", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getKMFileDownloadURL(@ApiParam(value = "{}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		logger.info("add file request is " + request);
		try {
			KMFileManager kmFileManager = InputMapper.getInstance().fromJson(request, KMFileManager.class);
			String s = schemeServiceImpl.getFilePath(kmFileManager);
			if (s != null)
				response.setResponse(s);
		} catch (Exception e) {
			logger.error("Error while getting file download url : " + e);
			response.setError(5000, "Error while getting file download url : " + e);
		}
		return response.toString();
	}
}
