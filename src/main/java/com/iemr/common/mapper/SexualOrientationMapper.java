package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.beneficiary.SexualOrientation;
import com.iemr.common.model.userbeneficiary.SexualOrientationModel;

@Mapper(componentModel = "spring")
@DecoratedWith(SexualOrientationMapperDecorator.class)
public interface SexualOrientationMapper
{
	SexualOrientationMapper INSTANCE = Mappers.getMapper(SexualOrientationMapper.class);

	// @Mappings({@Mapping(source)})
	SexualOrientationModel sexualOrientationToModel(SexualOrientation sexualOrientationData);

	@IterableMapping(elementTargetType = SexualOrientationModel.class)
	List<SexualOrientationModel> sexualOrientationToModel(List<SexualOrientation> sexualOrientation);

	SexualOrientationModel sexualOrientationByIDToModel(Short sexualOrientationID);

	@IterableMapping(elementTargetType = SexualOrientationModel.class)
	List<SexualOrientationModel> sexualOrientationByIDToModel(List<Integer> sexualOrientation);

}
