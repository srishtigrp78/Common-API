package com.iemr.common.notification.agent.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * AlertAndNotificationCount: Object to hold notification details such as type & count for the Alerts & Notifications
 * widget when user/agent reaches dashboard.
 * 
 * @author KALPATH
 *
 */

@Data
@AllArgsConstructor
public class AlertAndNotificationCount
{
	private Integer notificationID;
	private String notificationType;
	private Integer notificationTypeID;
	private Long notificationTypeUnreadCount;
}
