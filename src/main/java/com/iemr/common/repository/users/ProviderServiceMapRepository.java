package com.iemr.common.repository.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.users.ProviderServiceMapping;

@Repository
@RestResource(exported = false)
public interface ProviderServiceMapRepository extends CrudRepository<ProviderServiceMapping, Integer>
{

	@Query("select map from ProviderServiceMapping map where "
			+ "map.providerServiceMapID = :providerServiceMapID ")
	ProviderServiceMapping findByID(@Param("providerServiceMapID") Integer providerServiceMapID);

}
