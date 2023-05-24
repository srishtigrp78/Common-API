package com.iemr.common.notification.agent.DTO;

import java.sql.Timestamp;

import lombok.Data;

/**
 * AlertAndNotificationDetail: Object to hold notification details such as type et al. for popup when the user/agent
 * clicks on the mini dashboard Alerts & Notifications widget.
 * 
 * @author SUNIL K SUNDARAM
 *
 */

@Data
public class AlertAndNotificationDetail
{
	private Integer notificationId;
	private String notificationSubject;
	private String notificationMessage;
	private String notificationType;
	private Integer notificationTypeCount;
	private String notificationStatus;
	private Timestamp startDate;
	private Timestamp endDate;
	private Timestamp createDate;
	private String createdBy;
}
