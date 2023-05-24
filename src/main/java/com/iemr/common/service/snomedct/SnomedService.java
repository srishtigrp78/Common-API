package com.iemr.common.service.snomedct;

import com.iemr.common.data.snomedct.SCTDescription;

public interface SnomedService {

	public SCTDescription findSnomedCTRecordFromTerm(String term);

	String findSnomedCTRecordList(SCTDescription sctdescription) throws Exception;

}