package com.iemr.common.repository.location;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.location.DistrictBlock;

@Repository
@RestResource(exported = false)
public interface LocationDistrictBlockRepository extends CrudRepository<DistrictBlock, Integer>
{

	@Query("select blockID, blockName from DistrictBlock where districtID = :id and deleted = false "
			+ "order by blockName asc")
	public Set<Objects[]> findBy(@Param("id") int id);
}
