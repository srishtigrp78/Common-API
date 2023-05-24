package com.iemr.common.repository.beneficiary;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.beneficiary.BeneficiaryEducation;

@Repository
@RestResource(exported = false)
public abstract interface EducationRepository extends CrudRepository<BeneficiaryEducation, Long>
{
	@Query("select educationID, educationType from BeneficiaryEducation where deleted = false order by educationType asc")
	public abstract Set<Objects[]> findActiveEducations();
}
