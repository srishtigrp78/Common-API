package com.iemr.common.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.userbeneficiarydata.Language;
import com.iemr.common.model.userbeneficiary.LanguageModel;

@Mapper(componentModel = "spring")
@DecoratedWith(LanguageMapperDecorator.class)
public interface LanguageMapper
{
	LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);

	LanguageModel languageToModel(Language language);

	LanguageModel languageToModelByID(Integer stateID);
}
