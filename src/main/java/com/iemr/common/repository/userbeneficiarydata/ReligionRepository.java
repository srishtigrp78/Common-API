package com.iemr.common.repository.userbeneficiarydata;

import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.userbeneficiarydata.Religion;

@Repository
@RestResource(exported = false)
public abstract interface ReligionRepository extends CrudRepository<Religion, Integer>
{
	@Query("select religionID, religionType, religionDesc from Religion where deleted = false")
	public abstract List<Objects[]> getActiveReligions();
}
