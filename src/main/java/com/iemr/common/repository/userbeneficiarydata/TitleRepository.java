package com.iemr.common.repository.userbeneficiarydata;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.userbeneficiarydata.Title;

@Repository
@RestResource(exported = false)
public abstract interface TitleRepository extends CrudRepository<Title, Long>
{
	@Query("select titleID, titleName, titleDesc from Title where deleted = false")
	public abstract Set<Objects[]> findAciveTitles();

	@Query("select title from Title title where title.deleted = false and title.titleID = :titleID")
	public Title findTitlesByID(@Param("titleID") Integer titleID);
}
