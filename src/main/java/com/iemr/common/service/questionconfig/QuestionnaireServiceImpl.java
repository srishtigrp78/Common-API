package com.iemr.common.service.questionconfig;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.iemr.common.data.questionconfig.QuestionnaireDetail;
import com.iemr.common.repository.questionconfig.QuestionnaireRepository;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

	private InputMapper inputMapper = new InputMapper();
	
	/**
	 * Question Type Repository
	 */
	private QuestionnaireRepository questionnaireRepository;
	
	/**
	 * Inject Question Type Repository
	 */
	public void setQuestionnaireRepository(QuestionnaireRepository questionnaireRepository){
		
		this.questionnaireRepository = questionnaireRepository;
	}
	
	@Override
	public String createQuestionnaire(String request) throws IEMRException {
		
		QuestionnaireDetail[] questionnaireDetails = inputMapper.gson().fromJson(request, QuestionnaireDetail[].class);
		
		for(QuestionnaireDetail detail :questionnaireDetails){
			
			detail = questionnaireRepository.save(detail);
		}
		
		return Arrays.toString(questionnaireDetails);
	}

	@Override
	public String getQuestionnaireList() {
		
		return questionnaireRepository.getQuestionnaireList().toString();
	}

}
