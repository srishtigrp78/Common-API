package com.iemr.common.repository.sms;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.sms.SMSNotification;

@Repository
@RestResource(exported = false)
public interface SMSNotificationRepository extends CrudRepository<SMSNotification, Long>
{

	@Query("select smsNotification from SMSNotification smsNotification "
			+ "where smsNotification.deleted <> true and smsNotification.phoneNo is not null and "
			+ "smsNotification.createdDate >= :previous AND smsNotification.createdDate <= :current and "
			+ "smsNotification.smsStatus = :smsStatus ")
	List<SMSNotification> findPendingSMSNotifications(@Param("smsStatus") Integer smsStatus,
			@Param("current") Timestamp current,@Param("previous") Timestamp previous);

}
