package com.iemr.common.repository.institute;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;


import com.iemr.common.data.institute.InstituteType;

@Repository
@RestResource(exported = false)
public interface InstituteTypeRepository extends CrudRepository<InstituteType, Long>
{
	@Query("select type from InstituteType type where type.providerServiceMapID = :providerServiceMapID and "
			+ "type.deleted = false order by institutionType asc")
	List<InstituteType> findAciveInstitutesTypes(@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select type from InstituteType type where providerServiceMapID is null and "
			+ "type.deleted = false order by institutionType asc")
	List<InstituteType> findAciveInstitutesTypes();

	// @Query("select institutionID, institutionName from Institute where "
	// + "Deleted = false and districtBranchMappingID = :districtBranchMappingID and "
	// + "districtID = :districtID and stateID = :stateID order by institutionName asc")
	// public abstract Set<Objects[]> findAciveInstitutesByStateDistBlockID(@Param("stateID") int stateID,
	// @Param("districtID") int districtID, @Param("districtBranchMappingID") int districtBranchMappingID);
}

