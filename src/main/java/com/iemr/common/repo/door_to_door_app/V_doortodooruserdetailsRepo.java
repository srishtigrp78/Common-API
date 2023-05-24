package com.iemr.common.repo.door_to_door_app;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.data.door_to_door_app.V_doortodooruserdetails;

@Repository
@RestResource(exported = false)
public interface V_doortodooruserdetailsRepo extends CrudRepository<V_doortodooruserdetails, Integer> {

	public ArrayList<V_doortodooruserdetails> findByUserID(Integer userID);

	@Query(nativeQuery = true, value = "SELECT suspected_hrp, suspected_tb, suspected_ncd, suspected_ncd_diseases "
			+ " FROM db_identity.i_cbacdetails WHERE BeneficiaryRegID = :benRegID "
			+ " AND  (suspected_hrp = 'yes' OR suspected_tb = 'yes' OR suspected_ncd = 'yes' ) ")
	public ArrayList<Object[]> ncd_tb_hrp_Status(@Param("benRegID") Long benRegID);
	
	@Query(nativeQuery = true,value = "SELECT * FROM db_identity.i_external_beneficiary_json  "
			+ "WHERE BenId is null AND deleted is false limit :limit")
	public ArrayList<Object[]> getAvniBeneficiary(@Param("limit") Integer limit);
	
	@Query(nativeQuery = true,value = "SELECT count(*) FROM db_identity.i_external_beneficiary_json "
			+ "WHERE ExternalId = :avniId AND BenId is not null")
	public Integer checkIfAvniIdExists(@Param("avniId") String avniId);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true,value = "UPDATE db_identity.i_external_beneficiary_json SET BenId = :benId "
			+ "WHERE id = :id")
	public int updateAvniBenId(@Param("id") Long id,@Param("benId") Long benId);
}