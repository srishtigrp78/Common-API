package com.iemr.common.repository.users;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.users.Servicepointvillagemap;

@Repository
@RestResource(exported = false)
public interface ServicePointVillageMappingRepo extends CrudRepository<Servicepointvillagemap, Integer>{
	@Query("SELECT d.districtBranchID,d.villageName from Servicepointvillagemap s "
			+ " INNER JOIN s.districtBranchMapping d"
			+ " WHERE s.servicePointID = :servicePointID and s.deleted != 1 ")
	public List<Object[]> getServicePointVillages(@Param("servicePointID") Integer servicePointID);
}
