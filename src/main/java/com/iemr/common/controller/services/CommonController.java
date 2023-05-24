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

import com.iemr.common.service.services.CommonService;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/service")
public class CommonController
{
	InputMapper inputMapper = new InputMapper();
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@CrossOrigin()
	@RequestMapping(value = "/category", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	// public Iterable<CategoryDetails> getCategories(){
	public String getCategories(@ApiParam("{\"providerServiceMapID\":\"Integer\", "
			+ "\"subServiceID\":\"subServiceID\"}") @RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			response.setResponse(commonService.getCategories(request).toString());
		} catch (Exception e)
		{
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/subcategory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getSubcategories(@ApiParam("{\"categoryID\":\"Integer\"}") @RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			response.setResponse(commonService.getSubCategories(request).toString());
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	// getSubCategoryFiles
	@CrossOrigin()
	@RequestMapping(value = "/getSubCategoryFiles", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getSubCategoryFiles(@ApiParam("{\"categoryID\":\"Integer\", \"providerServiceMapID\":\"Integer\", "
			+ "\"subCategoryID\":\"Integer\"}") @RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			response.setResponse(commonService.getSubCategoryFiles(request).toString());
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	// getSubCategoryFiles
	@CrossOrigin()
	@RequestMapping(value = "/getSubCategoryFilesWithURL", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String
			getSubCategoryFilesWithURL(@ApiParam("{\"categoryID\":\"Integer\", \"providerServiceMapID\":\"Integer\", "
					+ "\"subCategoryID\":\"Integer\"}") @RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			response.setResponse(commonService.getSubCategoryFilesWithURL(request).toString());
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/categoryByID", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getcategoriesById(@ApiParam(value="\"{\\\"subServiceID\\\":\\\"String\\\",\\\"providerServiceMapID\\\":\\\"String\\\"}\"")
	@RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			// SubService subService = inputMapper.gson().fromJson(request, SubService.class);
			response.setResponse(commonService.getCategories(request).toString());
		} catch (

		Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/servicetypes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getservicetypes(@ApiParam("{\"providerServiceMapID\":\"Integer\"}") @RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			response.setResponse(commonService.getActiveServiceTypes(request).toString());
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	/**
	 * Designation Service
	 */
	private CommonService commonService;

	@Autowired
	public void setCommonService(CommonService commonService)
	{
		this.commonService = commonService;
	}
}
