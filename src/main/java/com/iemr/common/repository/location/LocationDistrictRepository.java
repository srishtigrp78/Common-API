package com.iemr.common.repository.location;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.location.Districts;

@Repository
@RestResource(exported = false)
public interface LocationDistrictRepository extends CrudRepository<Districts, Integer> {

	@Query("select districtID, districtName from Districts where stateID = :id order by districtName asc")
	public ArrayList<Objects[]> findBy(@Param("id") int id);
	
	@Query("select D.districtID, D.districtName, S.stateName, S.stateID "
			+ "from Districts D, States S "
			+ "where D.districtID = :id and S.stateID = D.stateID order by D.districtName asc")
	public ArrayList<Objects[]> findStateDistrictBy(@Param("id") int id);
	
	//for everwell districtID
	
	@Query("select districtID from Districts d where d.districtName = :districtName")
	public Integer getDistrictID(@Param ("districtName") String districtName);
	
}
