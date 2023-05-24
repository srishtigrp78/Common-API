package com.iemr.common.repository.beneficiary;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.beneficiary.BenRelationshipType;

@Repository
@RestResource(exported = false)
public interface BeneficiaryRelationshipTypeRepository extends CrudRepository<BenRelationshipType, Long>
{
	@Query("select benRelationshipID, benRelationshipType from BenRelationshipType where deleted = false "
			+ "order by benRelationshipType asc")
	Set<Objects[]> getActiveRelationships();

	@Query("select relation from BenRelationshipType relation where deleted = false and "
			+ "relation.benRelationshipID = :relationshipID")
	BenRelationshipType findByID(@Param("relationshipID") Integer relationshipID);
}
