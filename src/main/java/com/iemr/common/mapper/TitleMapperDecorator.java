package com.iemr.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.model.user.TitleModel;
import com.iemr.common.repository.userbeneficiarydata.TitleRepository;

public abstract class TitleMapperDecorator implements TitleMapper
{
	@Autowired
	TitleRepository titleRepository;
	
	public TitleModel titleByIDToResponse(Integer titleID){
		TitleModel titleModel = new TitleModel();
		if (titleID != null)
		{
			titleModel = titleToResponse(titleRepository.findTitlesByID(titleID));
		}
		return titleModel;
	}
}
