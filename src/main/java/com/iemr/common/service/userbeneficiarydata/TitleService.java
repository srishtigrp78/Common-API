package com.iemr.common.service.userbeneficiarydata;

import java.util.List;

import com.iemr.common.data.userbeneficiarydata.Title;

public abstract interface TitleService {
	public abstract List<Title> getActiveTitles();
}
