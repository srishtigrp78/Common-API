package com.iemr.common.repository.brd;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.helpline104history.H104BenMedHistory;



@Repository
public interface BRDIntegrationRepository extends CrudRepository<H104BenMedHistory, Long>{
	
	@Query(value = "call Pr_104IntegrationBhayaData(:startDate,:endDate)", nativeQuery = true)
	ArrayList<Object[]> getData(@Param("startDate")String startDate,@Param("endDate")String endDate);

}
