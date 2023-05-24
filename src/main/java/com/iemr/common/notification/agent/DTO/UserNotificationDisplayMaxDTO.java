package com.iemr.common.notification.agent.DTO;

import lombok.Data;

/**
 * UserNotificationDisplayMaxDTO: Contract Incoming Incoming DTO to capture multiple fields that will help pull the
 * dashboard related long data based on the Notification Type the user clicked and displays all such specific alert
 * and/or notification.
 * 
 * 
 * @author KALPATH
 *
 */

@Data
public class UserNotificationDisplayMaxDTO
{
	private Integer userID;
	private Integer roleID;
	private Integer notificationTypeID;
	private Integer providerServiceMapID;
	private Integer workingLocationID;
}
