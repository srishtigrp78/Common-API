package com.iemr.common.notification.agent.DTO;

import lombok.Data;

/**
 * UserNotificationCreateDTO: Contract Incoming All data that is necessary for creating User Notification. This table
 * required to maintain state per user, regarding alerts and/or notifications that have been read, unread, deleted.
 * 
 * @author SUNIL K SUNDARAM
 *
 */

@Data
public class UserNotificationCreateDTO
{
	private Integer notificationID;
	private Integer userID;
	private Integer roleID;
	private Integer providerServiceMapID;
	private String notificationState;
	private String createdBy;
	private String modifiedBy;
	private Boolean deleted;
}