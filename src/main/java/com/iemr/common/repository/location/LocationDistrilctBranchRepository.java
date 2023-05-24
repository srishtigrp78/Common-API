package com.iemr.common.repository.location;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.location.DistrictBranchMapping;

@Repository
@RestResource(exported = false)
public interface LocationDistrilctBranchRepository extends CrudRepository<DistrictBranchMapping, Integer>
{

	@Query("select districtBranchID, villageName from DistrictBranchMapping where blockID = :id and deleted = false "
			+ "order by villageName asc")
	public ArrayList<Objects[]> findBy(@Param("id") int id);

	@Query("select districtBranchID, villageName, panchayatName, habitat, pinCode from DistrictBranchMapping "
			+ "where blockID = :id and deleted = false order by villageName asc")
	public ArrayList<Objects[]> findAllBy(@Param("id") int id);
}
