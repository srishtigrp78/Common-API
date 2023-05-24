package com.iemr.common.notification.agent.DTO;

import java.util.List;

import lombok.Data;

/**
 * UserNotificationStatusShortDisplayDTO: Contract Outgoing Outgoing DTO that will have information necessary to display
 * details of all alert types and counts against each. This DTO will be sent every time the user reaches the Dashboard -
 * either via a login, re-login and/or closing a call.
 * 
 * Details available in this are: 1. User ID 2. User Name 3. List of: a. Notification Type b. Count of Unread for that
 * Notification Type
 * 
 * @author SUNIL K SUNDARAM
 *
 */

@Data
public class AlertAndNotificationCountDTO
{
	private Integer userId;
	private String userName;
	private List<AlertAndNotificationCount> userNotificationTypeList;
}
