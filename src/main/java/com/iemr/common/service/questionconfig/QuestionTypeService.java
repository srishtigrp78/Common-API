package com.iemr.common.service.questionconfig;

import com.iemr.common.utils.exception.IEMRException;

/**
 * @author VI314759
 * 
 *  Questioner for MCTS and 104
 */
public interface QuestionTypeService
{

	/**
	 * @param request
	 * @return
	 * @throws IEMRException
	 */
	String createQuestionType(String request) throws IEMRException;

	/**
	 * @return
	 */
	String getQuestionTypeList();

}
