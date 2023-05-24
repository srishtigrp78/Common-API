package com.iemr.common.repository.users;


import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.users.LoginSecurityQuestions;

@Repository
@RestResource(exported = false)
public interface IEMRUserLoginSecurityRepository extends CrudRepository<LoginSecurityQuestions, Integer> {


	@Query("select QuestionID, Question from LoginSecurityQuestions")
	ArrayList<Objects[]> getAllLoginSecurityQuestions();
}
