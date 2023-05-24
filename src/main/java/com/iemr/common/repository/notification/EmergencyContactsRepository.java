package com.iemr.common.repository.notification;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.data.notification.EmergencyContacts;

@Repository
@RestResource(exported = false)
public interface EmergencyContactsRepository extends CrudRepository<EmergencyContacts, Long>
{
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Modifying
	@Query("update EmergencyContacts " + "set designationID = :designationID, emergContactNo = :emergContactNo, "
			+ "emergContactDesc = :emergContactDesc, providerServiceMapID = :providerServiceMapID, "
			+ "deleted = :deleted, notificationTypeID = :notificationTypeID, emergContactName = :emergContactName, "
			+ "location = :location, modifiedBy = :modifiedBy " + "where emergContactID = :emergContactID")
	Integer updateEmergencyContacts(@Param("emergContactID") Integer emergContactID,
			@Param("designationID") Integer designationID, @Param("emergContactNo") String emergContactNo,
			@Param("emergContactDesc") String emergContactDesc,
			@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("notificationTypeID") Integer notificationTypeID, @Param("deleted") Boolean deleted,
			@Param("modifiedBy") String modifiedBy, @Param("emergContactName") String emergContactName,
			@Param("location") String location);

	// @Query("select new EmergencyContacts(contacts.emergContactID, contacts.designationID, contacts.emergContactNo, "
	// + "contacts.emergContactDesc, contacts.providerServiceMapID, provider, "
	// + "contacts.notificationTypeID, notificationType, contacts.deleted, contacts.createdDate) "
	// + "from EmergencyContacts contacts join contacts.providerServiceMapping provider "
	// + "join contacts.providerServiceMapping notificationType "
	// + "where contacts.providerServiceMapID = :providerServiceMapID and "
	// + "contacts.notificationTypeID = :notificationTypeID and contacts.deleted = false")
	// List<EmergencyContacts> getEmergencyContacts(@Param("providerServiceMapID") Integer providerServiceMapID,
	// @Param("notificationTypeID") Integer notificationTypeID);
	//
	// @Query("select new EmergencyContacts(contacts.emergContactID, contacts.designationID, contacts.emergContactNo, "
	// + "contacts.emergContactDesc, contacts.providerServiceMapID, provider, "
	// + "contacts.notificationTypeID, notificationType, contacts.deleted, contacts.createdDate) "
	// + "from EmergencyContacts contacts join contacts.providerServiceMapping provider "
	// + "join contacts.providerServiceMapping notificationType "
	// + "where contacts.providerServiceMapID = :providerServiceMapID and "
	// + "contacts.notificationTypeID = :notificationTypeID")
	// List<EmergencyContacts> getSupervisorEmergencyContacts(@Param("providerServiceMapID") Integer
	// providerServiceMapID,
	// @Param("notificationTypeID") Integer notificationTypeID);

	@Query("select contacts.emergContactID, contacts.designationID, contacts.emergContactName, "
			+ "contacts.emergContactNo, contacts.emergContactDesc, contacts.providerServiceMapID, provider, "
			+ "contacts.notificationTypeID, notificationType, contacts.location, contacts.deleted, "
			+ "contacts.createdDate, designation from EmergencyContacts contacts "
			+ "join contacts.providerServiceMapping provider join contacts.notificationType notificationType "
			+ "join contacts.designation designation where contacts.providerServiceMapID = :providerServiceMapID and "
			+ "contacts.notificationTypeID = :notificationTypeID and contacts.deleted = false")
	Set<Objects[]> getEmergencyContacts(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("notificationTypeID") Integer notificationTypeID);

	@Query("select contacts.emergContactID, contacts.designationID, contacts.emergContactName, "
			+ "contacts.emergContactNo, contacts.emergContactDesc, contacts.providerServiceMapID, provider, "
			+ "contacts.notificationTypeID, notificationType, contacts.location, contacts.deleted, "
			+ "contacts.createdDate, designation from EmergencyContacts contacts "
			+ "join contacts.providerServiceMapping provider join contacts.notificationType notificationType "
			+ "join contacts.designation designation where contacts.providerServiceMapID = :providerServiceMapID and "
			+ "contacts.notificationTypeID = :notificationTypeID")
	Set<Objects[]> getSupervisorEmergencyContacts(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("notificationTypeID") Integer notificationTypeID);

}