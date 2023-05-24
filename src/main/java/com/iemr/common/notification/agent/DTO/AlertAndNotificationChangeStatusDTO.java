package com.iemr.common.notification.agent.DTO;

import java.util.List;

import lombok.Data;

/**
 * UserNotficationStatusChangeDTO: Contract Incoming
 * 		DTO to handle INCOMING request to change Notification Status for a particular User.
 * 		Following operations are allowed:
 * 			1. Mark single Notification or a list of Notifications (notficationStatus = "read")
 * 			2. Unmark single Notification or a list of Notifications (notficationStatus = "unread")
 * 			3. Delete single Notification or a list of Notifications (notficationStatus = "delete")
 * 
 * @author SUNIL K SUNDARAM
 *
 */

@Data
public class AlertAndNotificationChangeStatusDTO
{
	private String notficationStatus;
	private List<Integer> userNotificationMapIDList;

}
