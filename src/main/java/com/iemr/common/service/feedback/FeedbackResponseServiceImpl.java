package com.iemr.common.service.feedback;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.feedback.FeedbackRequest;
import com.iemr.common.data.feedback.FeedbackResponse;
import com.iemr.common.repository.feedback.FeedbackRepository;
import com.iemr.common.repository.feedback.FeedbackRequestRepository;
import com.iemr.common.repository.feedback.FeedbackResponseRepository;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;

@Service
public class FeedbackResponseServiceImpl implements FeedbackResponseService {

	private InputMapper inputMapper = new InputMapper();
	private FeedbackResponseRepository feedbackResponseRepository;

	@Autowired
	public void setFeedbackResponseRepository(FeedbackResponseRepository feedbackResponseRepository) {
		this.feedbackResponseRepository = feedbackResponseRepository;
	}

	private FeedbackRequestRepository feedbackRequestRepository;

	@Autowired
	public void setFeedbackRequestRepository(FeedbackRequestRepository feedbackRequestRepository) {
		this.feedbackRequestRepository = feedbackRequestRepository;
	}

	private FeedbackRepository feedbackRepository;

	@Autowired
	public void setFeedbackRepository(FeedbackRepository feedbackRepository) {
		this.feedbackRepository = feedbackRepository;
	}

	@Override
	public FeedbackResponse getFeedbackResponse(Long feedbackResponseID) {
		return feedbackResponseRepository.findOne(feedbackResponseID);
	}

	@Override
	public FeedbackResponse createFeedbackResponse(FeedbackResponse t_feedbackResponse) {
		return feedbackResponseRepository.save(t_feedbackResponse);
	}

	@Override
	public FeedbackRequest createFeedbackRequest(FeedbackRequest feedbackRequest) {
		return feedbackRequestRepository.save(feedbackRequest);
	}

	@Override
	public String updateResponce(String feedbackresponce) throws IEMRException {
		FeedbackResponse responseObj = inputMapper.gson().fromJson(feedbackresponce, FeedbackResponse.class);
		responseObj = feedbackResponseRepository.save(responseObj);
		return responseObj.toString();

	}

	@Override
	public ArrayList<Object[]> getdataById(Long feedbackID) {
		return feedbackResponseRepository.getdatabyId(feedbackID);
	}
}
