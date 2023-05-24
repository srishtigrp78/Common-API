package com.iemr.common.repository.services;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.users.ServiceMaster;



@Repository
@RestResource(exported = false)
public interface ServiesRepository extends CrudRepository<ServiceMaster, Long> {
	@Query(value = "select serviceID, serviceName, serviceDesc, deleted from ServiceMaster where deleted = false")
	public Set<Objects[]> getActiveServicesList();
}
