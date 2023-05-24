package com.iemr.common.repository.helpline104history;

import java.util.ArrayList;
import java.util.Objects;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.helpline104history.H104BenMedHistory;

@Repository
@RestResource(exported = false)
public interface H104BenHistoryRepository extends CrudRepository<H104BenMedHistory, Long> {
	
	@Query("select u from H104BenMedHistory u where u.beneficiaryRegID = :BeneficiaryRegID order by u.benHistoryID desc")
	public ArrayList<Objects[]> getBenHistory(@Param("BeneficiaryRegID") Long BeneficiaryRegID);
	
	            
}
