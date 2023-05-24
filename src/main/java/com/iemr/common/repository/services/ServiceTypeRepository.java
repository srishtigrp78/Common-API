package com.iemr.common.repository.services;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.service.SubService;

@Repository
@RestResource(exported = false)
public interface ServiceTypeRepository extends CrudRepository<SubService, Integer>
{

	@Query("select subServiceID, subServiceName, subServiceDesc, deleted from SubService where "
			+ "providerServiceMapID = :providerServiceMapID")
	public ArrayList<Objects[]> findActiveServiceTypes(@Param("providerServiceMapID") Integer providerServiceMapID);
}
