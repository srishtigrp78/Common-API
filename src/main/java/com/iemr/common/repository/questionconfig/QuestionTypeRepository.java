package com.iemr.common.repository.questionconfig;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.questionconfig.QuestionTypeDetail;

@Repository
@RestResource(exported = false)
public interface QuestionTypeRepository extends CrudRepository<QuestionTypeDetail, Long> {

	@Query("select new QuestionTypeDetail(q.questionTypeID, q.questionType, q.questionTypeDesc) from QuestionTypeDetail q")
	public ArrayList<QuestionTypeDetail> getQuestionTypeList();
}
