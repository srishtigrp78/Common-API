package com.iemr.common.repository.directory;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.directory.Directory;

@Repository
@RestResource(exported = false)
public interface DirectoryRepository extends CrudRepository<Directory, Long>
{
	@Query("select instituteDirectoryID, instituteDirectoryName from Directory where deleted = false "
			+ "order by instituteDirectoryName asc")
	public Set<Objects[]> findAciveDirectories();

	@Query("select new Directory(instituteDirectoryID, instituteDirectoryName) from Directory where "
			+ "providerServiceMapID = :providerServiceMapID and deleted = false order by instituteDirectoryName asc")
	public List<Directory> findAciveDirectories(@Param("providerServiceMapID") Integer providerServiceMapID);
}
