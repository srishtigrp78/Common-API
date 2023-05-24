package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.userbeneficiarydata.Title;
import com.iemr.common.model.user.TitleModel;

@Mapper(componentModel = "spring")
@DecoratedWith(TitleMapperDecorator.class)
public interface TitleMapper
{
	TitleMapper INSTANCE = Mappers.getMapper(TitleMapper.class);

	TitleModel titleToResponse(Title m_Title);

	@IterableMapping(elementTargetType = TitleModel.class)
	List<TitleModel> titleToResponse(List<Title> m_TitleList);
	
	TitleModel titleByIDToResponse(Integer m_TitleID);

	@IterableMapping(elementTargetType = TitleModel.class)
	List<TitleModel> titleByIDToResponse(List<Integer> m_TitleListID);
}