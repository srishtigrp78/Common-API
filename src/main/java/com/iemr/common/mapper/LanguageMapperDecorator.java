package com.iemr.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.model.userbeneficiary.LanguageModel;
import com.iemr.common.repository.userbeneficiarydata.LanguageRepository;

public abstract class LanguageMapperDecorator implements LanguageMapper
{
	@Autowired
	LanguageRepository langRepo;

	public LanguageModel languageToModelByID(Integer languageID)
	{
		LanguageModel language = null;
		if (languageID != null)
		{
			language = languageToModel(langRepo.findOne(languageID));
		}
		return language;
	}
}
