package com.iemr.common.repository.beneficiary;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.beneficiary.GovtIdentityType;

@Repository
@RestResource(exported = false)
public interface GovtIdentityTypeRepository extends CrudRepository<GovtIdentityType, Integer>
{
	@Query("select govtIdentityTypeID, identityType, isGovtID, deleted, createdBy "
			+ "from GovtIdentityType where deleted=false order by identityType asc")
	public Set<Objects[]> getActiveIDTypes();
}
