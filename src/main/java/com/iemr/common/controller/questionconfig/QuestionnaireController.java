package com.iemr.common.controller.questionconfig;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.service.questionconfig.QuestionnaireService;
import com.iemr.common.utils.response.OutputResponse;

@RestController
@RequestMapping("/questionnaireController")
public class QuestionnaireController
{

	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * Question Type Repository
	 */
	private QuestionnaireService questionnaireService;

	/**
	 * Inject Question Type Repository
	 */
	public void setQuestionnaireService(QuestionnaireService questionnaireService)
	{

		this.questionnaireService = questionnaireService;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@CrossOrigin()
	@RequestMapping(value = "/put/questionnaire", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String createQuestionnaire(@RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			response.setResponse(questionnaireService.createQuestionnaire(request));
		} catch (Exception e)
		{
			logger.error("put-questionnaire failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@CrossOrigin()
	@RequestMapping(value = "/get/questionnaireList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String questionTypeList()
	{
		OutputResponse response = new OutputResponse();
		try
		{
			response.setResponse(questionnaireService.getQuestionnaireList());
		} catch (Exception e)
		{
			logger.error("get-questionnaire failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}
}
