package com.iemr.common.repository.users;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.users.MasterServicePoint;

@Repository
@RestResource(exported = false)
public interface MasterServicePointRepo extends CrudRepository<MasterServicePoint, Integer> {
	@Query(" SELECT msp.servicePointID, msp.servicePointName from MasterServicePoint msp WHERE msp.deleted != 1 ")
	public List<Object[]> getUserSevicePointList(@Param("parkingPlaceIdList") Set<Integer> parkingPlaceIdList);

}
