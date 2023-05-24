package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.model.beneficiary.BenRelationshipTypeModel;

@Mapper(componentModel = "spring")
@DecoratedWith(RelationshipMapperDecorator.class)
public interface RelationshipMapper
{
	RelationshipMapper INSTANCE = Mappers.getMapper(RelationshipMapper.class);

	BenRelationshipTypeModel createRelationshipTypes(BenRelationshipType relationship);

	List<BenRelationshipTypeModel> createRelationshipTypes(List<BenRelationshipType> relationship);

	BenRelationshipTypeModel createRelationshipTypesByID(Integer relationship);

	List<BenRelationshipTypeModel> createRelationshipTypesByID(List<Integer> relationship);
}
