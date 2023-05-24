package com.iemr.common.repository.scheme;

import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.data.scheme.Scheme;

@Repository
@RestResource(exported = false)
public interface SchemeRepository extends CrudRepository<Scheme, Long>
{

	@Query("select s.schemeID, s.schemeName, s.schemeDesc, s.kmFileManagerID, s.providerServiceMapID, s.deleted, s.createdBy, "
			+ "s.kmFileManager  from Scheme s Left JOIN s.kmFileManager k "
			+ "where s.providerServiceMapID=:providerServiceMapID " + "order by s.schemeName asc")
	public List<Objects[]> getschemeList(@Param("providerServiceMapID") Integer providerServiceMapID) throws Exception;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Modifying
	@Query("update Scheme set kmFileManagerID = :kmFileManagerID where schemeID = :schemeID")
	Integer updateScheme(@Param("schemeID") Integer schemeID, @Param("kmFileManagerID") Integer kmFileManagerID);

	@Query("SELECT u FROM Scheme u where u.schemeID = :schemeID")
	Scheme getSchemeByID(@Param("schemeID") Integer schemeID);

}
