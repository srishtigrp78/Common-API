package com.iemr.common.service.questionconfig;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.questionconfig.QuestionTypeDetail;
import com.iemr.common.repository.questionconfig.QuestionTypeRepository;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {

	InputMapper inputMapper = new InputMapper();
	
	/**
	 * Question Type Repository
	 */
	@Autowired
	private QuestionTypeRepository questionTypeRepository;
	
	/**
	 * Inject Question Type Repository
	 */
	public void setQuestionTypeRepository(QuestionTypeRepository questionTypeRepository){
		
		this.questionTypeRepository = questionTypeRepository;
	}
	
	/**
	 * method to save question type array
	 * @param string request
	 * @throws IEMRException 
	 */
	@Override
	public String createQuestionType(String request) throws IEMRException {
		
		QuestionTypeDetail[] questionTypeDetails = inputMapper.gson().fromJson(request, QuestionTypeDetail[].class);
		
		for(QuestionTypeDetail questionTypeDetail :questionTypeDetails){
			
			questionTypeDetail = questionTypeRepository.save(questionTypeDetail);
		}
		
		return Arrays.toString(questionTypeDetails);
	}

	@Override
	public String getQuestionTypeList() {
		
		return questionTypeRepository.getQuestionTypeList().toString();
	}

}
