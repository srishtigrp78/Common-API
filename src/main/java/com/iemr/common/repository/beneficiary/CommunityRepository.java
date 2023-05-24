package com.iemr.common.repository.beneficiary;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.userbeneficiarydata.Community;

@Repository
@RestResource(exported = false)
public abstract interface CommunityRepository extends CrudRepository<Community, Integer>
{
	@Query("select communityID, communityType from Community where deleted = false order by communityType asc")
	public abstract Set<Objects[]> findAciveCommunities();

	@Query("select community from Community community where community.deleted = false and "
			+ "community.communityID = :communityID order by communityType asc")
	public abstract Community findCommunity(@Param("communityID") Integer communityID);
}
