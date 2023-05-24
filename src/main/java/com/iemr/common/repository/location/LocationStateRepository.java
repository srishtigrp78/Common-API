package com.iemr.common.repository.location;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.location.States;

@Repository
@RestResource(exported = false)
public interface LocationStateRepository extends CrudRepository<States, Integer>
{

	@Query("select stateID, stateName from States where countryID = :id order by stateName asc")
	public ArrayList<Objects[]> findBy(@Param("id") int id);
	
	@Query("select state from States state where state.stateID = :id")
	public States findByStateID(@Param("id") int id);
	
	//For everwell stateID
	@Query("select stateID from States t where t.stateName = :stateName ")
	public Integer getStateID(@Param("stateName") String stateName);
	
	// for everwell - fetching the langugae according to state.
	@Query("select t.language from States t where t.stateName = :stateName ")
	public String getStateLanguage(@Param("stateName") String stateName);
}
