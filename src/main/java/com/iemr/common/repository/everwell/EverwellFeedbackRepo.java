package com.iemr.common.repository.everwell;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.data.everwell.EverwellFeedback;

@Repository
@RestResource(exported = false)
public interface EverwellFeedbackRepo extends CrudRepository<EverwellFeedback, Long> {

	@Query("select req from EverwellFeedback req  where req.dateOfAction is not null and req.actionTaken is not null and "
			+ "req.category is not null and req.subCategory is not null and req.comments is not null and req.isManualDoseProcessed is false and req.Id =:patientID")
	ArrayList<EverwellFeedback> findRecordsForManualDose(@Param("patientID") Long patientID);

	@Query("select req from EverwellFeedback req  where req.dateOfAction is not null and req.actionTaken is not null and "
			+ "req.category is not null and req.subCategory is not null and req.comments is not null and req.isMissedDoseProcessed is false and req.Id =:patientID")
	ArrayList<EverwellFeedback> findRecordsForMissedDose(@Param("patientID") Long patientID);

	@Query("select req from EverwellFeedback req  where req.dateOfAction is not null and req.actionTaken is not null and "
			+ "req.category is not null and req.subCategory is not null and req.comments is not null and req.isSupportActionProcessed is false and req.Id =:patientID")
	ArrayList<EverwellFeedback> findRecordsForAddSupportAction(@Param("patientID") Long patientID);

	@Query("select req from EverwellFeedback req  where req.dateOfAction is not null and req.actionTaken is not null and "
			+ "req.category is not null and req.subCategory is not null and req.comments is not null and req.isMobileNumberProcessed is false and "
			+ "req.secondaryPhoneNo is not null and req.Id =:patientID")
	ArrayList<EverwellFeedback> findRecordsForEditSecondaryPhoneN0(@Param("patientID") Long patientID);

	@Query("SELECT req FROM EverwellFeedback req  WHERE req.dateOfAction is not null AND req.actionTaken is not null AND "
			+ "req.category is not null AND req.subCategory is not null AND req.comments is not null AND req.isMobileNumberProcessed is false OR "
			+ "req.isManualDoseProcessed is false OR req.isMissedDoseProcessed is false OR req.isSupportActionProcessed is false "
			+ "AND req.secondaryPhoneNo is not null AND req.Id =:patientID")
	ArrayList<EverwellFeedback> findRecordsForDataSync(@Param("patientID") Long patientID);

	@Query("SELECT req FROM EverwellFeedback req WHERE req.createdDate >= :previous AND req.createdDate <= :current AND "
			+ " (req.processed= 'N' OR req.processed= 'U') AND req.deleted is false "
			+ " group by everwellid,dateofaction ")
	ArrayList<EverwellFeedback> findRecordsForDataSyncFromFeedback(@Param("current") Timestamp current,
			@Param("previous") Timestamp previous);

	// Shubham Shekhar,24-12-2020,Everwell Phase3
	@Query("SELECT req FROM EverwellFeedback req WHERE req.Id = :Id AND date(req.dateOfAction) = date(:dateOfAction) AND "
			+ " req.deleted is false order by req.efid desc ")
	ArrayList<EverwellFeedback> getExistingRecords(@Param("Id") Long Id, @Param("dateOfAction") Timestamp dateOfAction);

	@Transactional
	@Modifying
	@Query("UPDATE EverwellFeedback SET processed= 'P' WHERE Id = :Id AND date(dateOfAction) = date(:dateOfAction) AND "
			+ " (processed= 'N' OR processed= 'U') ")
	Integer updateDuplicateRecords(@Param("Id") Long Id, @Param("dateOfAction") Timestamp dateOfAction);

	/***
	 * @author DU20091017
	 * @param patientID
	 * @param currentDate
	 * @param lastDate
	 * @return modifying for phase 4
	 */
//	@Query("select req from EverwellFeedback req  where req.Id = :patientID and req.dateOfAction >= :lastDate and req.dateOfAction <= :currentDate "
//			+ "order by req.createdDate desc limit 1")
//	ArrayList<EverwellFeedback> getEverwellDetails(@Param("patientID") Long patientID,
//			@Param("currentDate") Timestamp currentDate, @Param("lastDate") Timestamp lastDate);

	@Query(nativeQuery = true, value = "select b.* from (SELECT DateOfAction,max(EFID) as EFID FROM t_everwellfeedback where EverWellID = :patientID and "
			+ "DateOfAction >= :lastDate and DateOfAction <= :currentDate "
			+ "group by DateOfAction) a inner join t_everwellfeedback b on a.EFID = b.EFID;")
	ArrayList<EverwellFeedback> getEverwellDetails(@Param("patientID") Long patientID,
			@Param("currentDate") Timestamp currentDate, @Param("lastDate") Timestamp lastDate);

	@Query(nativeQuery = true, value = "select b.* from (SELECT DateOfAction,max(EFID) as EFID FROM t_everwellfeedback where eapiId = :patientID and "
			+ "lastModDate >= :todayStart and lastModDate <= :todayEnd "
			+ "group by DateOfAction) a inner join t_everwellfeedback b on a.EFID = b.EFID;")
	ArrayList<EverwellFeedback> getEverwellDetailsForToday(@Param("patientID") Long patientID,
			@Param("todayStart") Timestamp todayStart, @Param("todayEnd") Timestamp todayEnd);

}
