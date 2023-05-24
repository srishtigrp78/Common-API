package com.iemr.common.repository.users;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.users.MasterVan;

@Repository
@RestResource(exported = false)
public interface MasterVanRepo extends CrudRepository<MasterVan, Integer> {
	@Query("Select mv.vanID, mv.vehicalNo from MasterVan mv WHERE mv.deleted != 1 and mv.parkingPlaceID in :parkingPlaceList ")
	public List<Object[]> getUserVanDatails(@Param("parkingPlaceList") Set<Integer> parkingPlaceList);
}
