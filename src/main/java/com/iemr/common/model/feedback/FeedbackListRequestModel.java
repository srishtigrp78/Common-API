package com.iemr.common.model.feedback;

import java.sql.Timestamp;
import java.util.Calendar;

import lombok.Data;

@Data
public class FeedbackListRequestModel
{
	private Integer serviceID;
	private Long beneficiaryRegID;
	private Long feedbackID;
	private String requestID;
	private Timestamp startDate = new Timestamp(0);
	private Timestamp endDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
	private Integer feedbackTypeID;
	private Boolean is1097 = false;
	private Long benCallID;
	private String phoneNum;
}
