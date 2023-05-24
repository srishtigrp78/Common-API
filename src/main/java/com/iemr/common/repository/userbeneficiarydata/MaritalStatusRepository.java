package com.iemr.common.repository.userbeneficiarydata;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.userbeneficiarydata.MaritalStatus;

@Repository
@RestResource(exported = false)
public abstract interface MaritalStatusRepository extends CrudRepository<MaritalStatus, Integer>
{
	@Query("select maritalStatusID, status from MaritalStatus where deleted = false order by status asc")
	public abstract Set<Objects[]> findAciveMaritalStatus();

	@Query("select maritalStatus from MaritalStatus maritalStatus where maritalStatus.deleted = false "
			+ "and maritalStatus.maritalStatusID = :maritalStatusID order by status asc")
	public MaritalStatus findAciveMaritalStatusByID(@Param("maritalStatusID") Integer maritalStatusID);
}
