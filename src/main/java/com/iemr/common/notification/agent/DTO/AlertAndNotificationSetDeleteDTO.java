package com.iemr.common.notification.agent.DTO;

import java.util.List;

import lombok.Data;

/**
 * UserNotficationStatusChangeDTO: Contract Incoming DTO to handle INCOMING request to change Notification Status for a
 * particular User. Following operations are allowed: 1. isDeleted = true => soft delete the entry 2. isDeleted = false
 * => undelete 3. Single vs. List entries
 * 
 * @author SUNIL K SUNDARAM
 *
 */

@Data
public class AlertAndNotificationSetDeleteDTO
{
	private Boolean isDeleted;
	private List<Integer> userNotificationMapIDList;
}
