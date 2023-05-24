package com.iemr.common.repository.location;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.location.Country;

@Repository
@RestResource(exported = false)
public interface LocationCountryRepository extends CrudRepository<Country, Integer>
{

	

}
