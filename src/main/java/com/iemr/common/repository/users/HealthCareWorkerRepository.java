package com.iemr.common.repository.users;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.healthCareWorkerType.HealthCareWorker;

@Repository
@RestResource(exported = false)
public interface HealthCareWorkerRepository extends CrudRepository<HealthCareWorker, Short>
{
	@Query("select healthCareWorker from HealthCareWorker healthCareWorker order by healthCareWorkerType asc")
	List<HealthCareWorker> findAllOrderByHealthCareWorkerTypeAsc();
}
