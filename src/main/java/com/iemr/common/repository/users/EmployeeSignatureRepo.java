package com.iemr.common.repository.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.users.EmployeeSignature;

@Repository
@RestResource(exported = false)
public interface EmployeeSignatureRepo extends CrudRepository<EmployeeSignature, Long> {

	EmployeeSignature findOneByUserID(Long userID);

	@Query("SELECT es.userSignatureID FROM EmployeeSignature es WHERE es.userID=:userid")
	Long findUserSignature(@Param("userid") Long userid);

	Long countByUserIDAndSignatureNotNull(Long userID);

//	@Transactional
//	@Modifying
//	@Query("update EmployeeSignature es set es.fileName=:fileName,es.fileType=:fileType "
//			+ " es.signature=:signature, es.modifiedBy=:modifiedBy where es.userSignatureID=:userSignatureID ")
//	void updateFile( @Param("userSignatureID")Long usrsignID, @Param("fileName") String fileName, @Param("fileType") String fileType,
//			@Param("signature") byte[] signature, @Param("modifiedBy") String modifiedBy);

}
