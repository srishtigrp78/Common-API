package com.iemr.common.service.helpline104history;

import java.util.ArrayList;
import java.util.Objects;

public interface H104BenHistoryService {
	
	ArrayList<Objects[]> geSmpleBenHistory(Long beneficiaryId);	

}
