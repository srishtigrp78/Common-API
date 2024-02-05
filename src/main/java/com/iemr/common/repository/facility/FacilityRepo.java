package com.iemr.common.repository.facility;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.facility.Facility;

@Repository
public interface FacilityRepo extends CrudRepository<Facility, Integer> {
	
	@Query(" SELECT eAusadhaFacilityId FROM Facility WHERE facilityId=:facilityId ")
	String fetchInstitutionId(@Param("facilityId") Integer facilityId);

}
