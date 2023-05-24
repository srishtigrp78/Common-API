package com.iemr.common.repository.notification;

import java.util.Objects;
import java.util.Set;

//import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.data.notification.NotificationType;

@Repository
@RestResource(exported = false)
public interface NotificationTypeRepository extends CrudRepository<NotificationType, Long>
{
	@Transactional
	@Modifying
	@Query("update NotificationType set notificationType = :notificationType, "
			+ "notificationTypeDesc = :notificationTypeDesc, deleted = :deleted, " + "modifiedBy = :modifiedBy "
			+ "where notificationTypeID = :notificationTypeID")
	Integer updateNotificationType(@Param("notificationTypeID") Integer notificationTypeID,
			@Param("notificationType") String notificationType,
			@Param("notificationTypeDesc") String notificationTypeDesc, @Param("deleted") Boolean deleted,
			@Param("modifiedBy") String modifiedBy);

	@Query("select notificationTypeID, notificationType, notificationTypeDesc, deleted from NotificationType "
			+ "where providerServiceMapID = :providerServiceMapID and deleted = false order by notificationType asc")
	Set<Objects[]> getNotificationTypes(@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select notificationTypeID, notificationType, notificationTypeDesc, deleted from NotificationType "
			+ "where deleted = false order by notificationType asc")
	Set<Objects[]> getNotificationTypes();

}
