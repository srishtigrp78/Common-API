package com.iemr.common.repository.kmfilemanager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.kmfilemanager.KMFileManager;

@Repository
@RestResource(exported = false)
public interface KMFileManagerRepository extends CrudRepository<KMFileManager, Long>
{
	@Query("update KMFileManager " + "set fileUID = :fileUID, fileName = :fileName, fileExtension = :fileExtension, "
			+ "versionNo = :versionNo, fileCheckSum = :fileCheckSum, "
			+ "providerServiceMapID = :providerServiceMapID, kmUploadStatus = :kmUploadStatus, "
			+ "validFrom = :validFrom, validUpto = :validUpto, deleted = :deleted, modifiedBy = :modifiedBy "
			+ "where kmFileManagerID=:kmFileManagerID")
	Integer updateKMFileManager(@Param("kmFileManagerID") Integer kmFileManagerID, @Param("fileUID") String fileUID,
			@Param("fileName") String fileName, @Param("fileExtension") String fileExtension,
			@Param("versionNo") String versionNo, @Param("fileCheckSum") String fileCheckSum,
			@Param("providerServiceMapID") Integer providerServiceMapID, @Param("kmUploadStatus") String kmUploadStatus,
			@Param("validFrom") Timestamp validFrom, @Param("validUpto") Timestamp validUpto,
			@Param("deleted") Boolean deleted, @Param("modifiedBy") String modifiedBy);

	@Query("select providerServiceMapID, kmFileManagerID, fileUID, fileName, fileExtension, versionNo, fileCheckSum, "
			+ "kmUploadStatus, validFrom, validUpto, deleted from KMFileManager "
			+ "where providerServiceMapID=:providerServiceMapID")
	Set<Objects[]> getKMFileLists(@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select files from KMFileManager files "
			+ "where files.providerServiceMapID = :providerServiceMapID and files.fileName = :fileName "
			+ "order by kmFileManagerID asc")
	List<KMFileManager> getKMFileByFileName(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("fileName") String fileName);

//	@Query("select new KMFileManager(providerServiceMapID, kmFileManagerID, fileUID, fileName, "
//			+ "fileExtension, versionNo, fileCheckSum, kmUploadStatus, validFrom, validUpto, deleted, createdBy) "
//			+ "from KMFileManager where providerServiceMapID=:providerServiceMapID and fileUID = :fileUID")
//	ArrayList<KMFileManager> getKMFileLists(@Param("providerServiceMapID") Integer providerServiceMapID,
//			@Param("fileUID") String fileUID);
	
	@Query("select kmFileManager from KMFileManager kmFileManager "
			+ "where kmFileManager.providerServiceMapID=:providerServiceMapID and kmFileManager.fileUID = :fileUID")
	ArrayList<KMFileManager> getKMFileLists(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("fileUID") String fileUID);
	
	@Query("select kmFileManager.fileName, kmFileManager.fileExtension from KMFileManager kmFileManager "
			+ "where kmFileManager.fileUID = :fileUID")
	List<Objects[]> getFileNameByUID(@Param("fileUID") String fileUID);

}
