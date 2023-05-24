package com.iemr.common.repository.questionconfig;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.questionconfig.QuestionnaireDetail;

@Repository
@RestResource(exported = false)
public interface QuestionnaireRepository extends CrudRepository<QuestionnaireDetail, Long> {

	@Query("select new QuestionnaireDetail(qn.questionID, qn.question, qn.questionDesc) from QuestionnaireDetail qn")
  	public ArrayList<QuestionnaireDetail> getQuestionnaireList();
}
