package com.iemr.common.service.beneficiary;

import java.util.List;

import com.iemr.common.data.beneficiary.BenRelationshipType;

public interface BenRelationshipTypeService {
	List<BenRelationshipType> getActiveRelationshipTypes();
}
