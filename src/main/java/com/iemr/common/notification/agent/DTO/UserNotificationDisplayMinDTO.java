package com.iemr.common.notification.agent.DTO;

import lombok.Data;

/**
 * UserNotificationDisplayMinDTO: Contract Incoming Incoming DTO to capture 3 fields that will help pull the dashboard
 * related min data - an aggregated count of user's unread alerts and notifications.
 * 
 * 
 * @author KALPATH
 *
 */

@Data
public class UserNotificationDisplayMinDTO
{
	private Integer userID;
	private Integer roleID;
	private Integer providerServiceMapID;
	private Integer workingLocationID;
}
