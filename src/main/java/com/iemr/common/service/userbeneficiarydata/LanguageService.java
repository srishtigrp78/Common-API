package com.iemr.common.service.userbeneficiarydata;

import java.util.List;

import com.iemr.common.data.userbeneficiarydata.Gender;
import com.iemr.common.data.userbeneficiarydata.Language;

public interface LanguageService {
	List<Language> getActiveLanguages();
}
