package com.iemr.common.repository.callhandling;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.telemedicine.TCRequestModel;

@Repository
@RestResource(exported = false)
public interface TCRequestModelRepo extends CrudRepository<TCRequestModel, Long> {
	@Query(value = " SELECT Specialization FROM db_iemr.m_specialization "
			+ " WHERE SpecializationID = :specializationID ", nativeQuery = true)
	public String getSpecializationDetail(@Param("specializationID") Integer specializationID);
}
