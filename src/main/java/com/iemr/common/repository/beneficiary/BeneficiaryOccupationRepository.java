package com.iemr.common.repository.beneficiary;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.beneficiary.BeneficiaryOccupation;

@Repository
@RestResource(exported = false)
public interface BeneficiaryOccupationRepository extends CrudRepository<BeneficiaryOccupation, Long> {
	@Query("select occupationID, occupationType from BeneficiaryOccupation where deleted = false "
			+ "order by occupationType asc")
	Set<Objects[]> getActiveOccupations();

}
