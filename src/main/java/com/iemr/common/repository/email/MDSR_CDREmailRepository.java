package com.iemr.common.repository.email;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.email.MDSR_CDREmail;

@Repository
@RestResource(exported = false)
public interface MDSR_CDREmailRepository extends CrudRepository<MDSR_CDREmail, Long>{

	@Query("SELECT mdsr_cdr FROM MDSR_CDREmail mdsr_cdr where mdsr_cdr.requestID = :requestID")
	MDSR_CDREmail getMSDR_CDRBenDetails(@Param("requestID") String requestID );
	
	@Query(value="call Pr_Benimrmmr_Demographicdetails(:VDistrict,:VBlock,:VVillage,:IDistrict,:IBlock,:IVIllage,:baseCommunityID,:transitTypeID)", nativeQuery=true)
	public ArrayList<Object[]> getDemographicDetails(@Param("VDistrict") Integer VDistrict,
			@Param("VBlock") Integer VBlock,@Param("VVillage") Integer VVillage,
			@Param("IDistrict") Integer IDistrict,@Param("IBlock") Integer IBlock,
			@Param("IVIllage") Integer IVIllage,@Param("transitTypeID") Integer transitTypeID,
			@Param("baseCommunityID") Integer baseCommunityID);
}
