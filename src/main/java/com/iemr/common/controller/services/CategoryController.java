package com.iemr.common.controller.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.data.category.CategoryDetails;
import com.iemr.common.service.category.CategoryService;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

@RestController
@RequestMapping(value = "/category")
public class CategoryController
{
	InputMapper inputMapper = new InputMapper();
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@CrossOrigin()
	@RequestMapping(value = "/categories", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getAllCategries(
			@Param("{\"providerServiceMapID\":\"Integer\", " + "\"subServiceID\":\"subServiceID\", " + "\"feedbackNatureID\":\"feedbackNatureID\"}") @RequestBody String request)
	{

		OutputResponse response = new OutputResponse();
		try
		{
			List<CategoryDetails> categoryList = new ArrayList<CategoryDetails>();
			categoryList = categoryService.getAllCategories(request);
			response.setResponse(categoryList.toString());
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}	
	

	/**
	 * Category srvice
	 */
	private CategoryService categoryService;

	/**
	 * Inject category service
	 */
	@Autowired
	public void setCategoryService(CategoryService categoryService)
	{
		this.categoryService = categoryService;
	}
}
