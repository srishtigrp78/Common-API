package com.iemr.common.repository.users;

import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.users.ServiceRoleScreenMapping;

@Repository
@RestResource(exported = false)
public interface ServiceRoleScreenMappingRepository extends CrudRepository<ServiceRoleScreenMapping, Long>
{

	// @Query("select new ServiceRoleScreenMapping().initializeRoleScreenMapping(m.srsMappingID, m.screenID, m.screen, "
	// + "m.providerServiceMapID, m.providerServiceMapping, m.roleID, m.role, m.deleted, m.createdBy) "
	// + "from ServiceRoleScreenMapping m left join m.screen ms left join m.role mr "
	// + "where m.providerServiceMapID = :providerServiceMapID and m.roleID = :roleID and m.deleted = false")
	// @Query("select new ServiceRoleScreenMapping(m.srsMappingID, m.screenID, m.screen, m.providerServiceMapID, "
	// + "m.providerServiceMapping, m.roleID, m.role, m.deleted, m.createdBy) "
	// + "from ServiceRoleScreenMapping m left join m.screen ms left join m.role mr "
	// + "where m.providerServiceMapID = :providerServiceMapID and m.roleID = :roleID and m.deleted = false")

	@Query("select m.srsMappingID, m.screenID, m.screen, m.providerServiceMapID, m.providerServiceMapping, m.roleID, "
			// + "m.role, "
			+ "m.deleted, m.createdBy from ServiceRoleScreenMapping m left join m.screen ms left join m.role mr "
			+ "where m.providerServiceMapID = :providerServiceMapID and m.roleID = :roleID and m.deleted = false "
			+ "order by m.srsMappingID")

	List<Objects[]> getActiveScreenMappings(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("roleID") Integer roleID);

	@Query("select m.srsMappingID, m.screenID, m.screen, m.providerServiceMapID, "
			+ "m.providerServiceMapping, m.roleID, "
			// + "m.role, "
			+ "m.deleted, m.createdBy from ServiceRoleScreenMapping m left join m.screen ms left join m.role mr "
			+ "where m.providerServiceMapID = :providerServiceMapID  and m.deleted = false "
			+ "order by m.srsMappingID")

	List<Objects[]> getActiveScreenMappingsForProvider(@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select m.srsMappingID, m.screenID, m.screen, m.deleted, m.createdBy "
			+ "from ServiceRoleScreenMapping m left join m.screen ms left join m.role mr "
			+ "where m.providerServiceMapID = :providerServiceMapID and m.roleID = :roleID and m.deleted = false "
			+ "order by m.srsMappingID")

	List<Objects[]> getRoleScreenMappings(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("roleID") Integer roleID);

}
