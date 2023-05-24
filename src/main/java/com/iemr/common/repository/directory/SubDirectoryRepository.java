package com.iemr.common.repository.directory;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.directory.SubDirectory;

@Repository
@RestResource(exported = false)
public interface SubDirectoryRepository extends CrudRepository<SubDirectory, Long> {
	// @Query("select instituteSubDirectoryID, instituteSubDirectoryName,
	// instituteDirectoryID from SubDirectory where Deleted = false and
	// instituteDirectoryID = :instituteDirectoryID")
	@Query("select instituteSubDirectoryID, instituteSubDirectoryName from SubDirectory where "
			+ "Deleted = false and instituteDirectoryID = :instituteDirectoryID order by instituteSubDirectoryName asc")
	public Set<Objects[]> findAciveSubDirectories(@Param("instituteDirectoryID") int instituteDirectoryID);
}
