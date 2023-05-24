package com.iemr.common.notification.agent.DTO;

import java.util.List;

import com.iemr.common.notification.agent.UserNotificationMapping;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

/**
 * AlertAndNotificationDetailDTO: Contract Outgoing Outgoing DTO that will have information necessary to display details
 * of all alert types for a given user after the initial click on the "Alerts & Notifications" widget. Where the user
 * wants to look at individual alert types and may want to interact with them via actions such as Unmark, Delete, Mark.
 * 
 * Details available are: 1. User Id 2. User Name 3. List of: a. Notification Id b. Notification Message c. Notification
 * Type d. Notification Type Count e. Notification Status f. Notification Start Date g. Notification End Date h.
 * Notification Create Date i. Notification Created By
 * 
 * 
 * @author SUNIL K SUNDARAM
 *
 */

@Data
public class AlertAndNotificationDetailDTO
{
	private Integer userId;
	private String userName;
	private List<UserNotificationMapping> userNotificationMappingList;

//	public void setUserNotificationMappingList (List<UserNotificationMapping> userNotificationMappingList) {
//		this.userNotificationMappingList = userNotificationMappingList;
//	}
//	
//	@Override
//	public String toString()
//	{
//		
//		return /*new Gson().toJson(this);*/ OutputMapper.gsonWithoutExposeRestriction().toJson(this);
//	}
}
