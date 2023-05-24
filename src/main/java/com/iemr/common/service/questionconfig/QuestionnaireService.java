package com.iemr.common.service.questionconfig;

import com.iemr.common.utils.exception.IEMRException;

public interface QuestionnaireService {

	String createQuestionnaire(String request) throws IEMRException;

	String getQuestionnaireList();

}
