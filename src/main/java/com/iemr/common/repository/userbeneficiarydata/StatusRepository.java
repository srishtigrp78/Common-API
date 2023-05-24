package com.iemr.common.repository.userbeneficiarydata;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.userbeneficiarydata.Status;

@Repository
@RestResource(exported = false)
public abstract interface StatusRepository extends CrudRepository<Status, Integer> {
	@Query("select statusID, status from Status where deleted = false")
	public abstract Set<Objects[]> findAciveStatus();
}
