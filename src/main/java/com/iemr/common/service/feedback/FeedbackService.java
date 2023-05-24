package com.iemr.common.service.feedback;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.data.feedback.FeedbackLog;
import com.iemr.common.model.feedback.FeedbackListRequestModel;

public interface FeedbackService {

	public List<FeedbackDetails> getFeedbackRequests(Long id);

	public List<FeedbackDetails> getFeedbackRequest(Long id);

	public FeedbackDetails createFeedback(FeedbackDetails feedbackDetails);
	
	public Integer updateFeedback(String feedbackDetails) throws Exception;

	public String saveFeedbackResponseFromAuthority(String feedbackDetails) throws Exception;

	public ArrayList<Object[]> getDateBetween(Timestamp startDate, Timestamp endDate);

	public ArrayList<Object[]> getFeedbackByID(Integer feedbackId);

	public String getAllData(String request) throws Exception;

	public String updateFeedbackStatus(String feedbackDetails) throws Exception;

	String searchFeedback(String feedbackDetails) throws Exception;

	public String searchFeedback1(String feedbackDetails) throws Exception;
	
	public String getFeedbackStatus(String feedbackStatus);
	
	public String getEmailStatus(String emailStatus);

	String saveFeedback(String feedbackDetails) throws Exception;
	
	String createFeedbackRequest(String feedbackRequestString) throws Exception;
	
	String updateResponse(String updateResponseString) throws Exception;

	String getFeedbacksList(FeedbackListRequestModel feedbackDetails, String authKey) throws Exception;

	String getGrievancesByCreatedDate(FeedbackListRequestModel feedbackDetails, String authKey) throws Exception;

	String getGrievancesByUpdatedDate(FeedbackListRequestModel feedbackDetails, String authKey) throws Exception;

	String saveFeedbackRequest(String feedbackRequestString) throws Exception;

	String getFeedbackLogs(FeedbackLog feedbackLogs) throws Exception;

}
