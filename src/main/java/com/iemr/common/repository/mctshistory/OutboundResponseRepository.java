package com.iemr.common.repository.mctshistory;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.mctshistory.MctsCallResponseDetail;

@Repository
@RestResource(exported = false)
public interface OutboundResponseRepository extends CrudRepository<MctsCallResponseDetail, Long> {

	@Query("select res from MctsCallResponseDetail res join res.questionnaireDetail where res.callDetailID = :callDetailID ")
	public ArrayList<MctsCallResponseDetail> getMctsCallResponse(@Param("callDetailID") Long callDetailID);

}
