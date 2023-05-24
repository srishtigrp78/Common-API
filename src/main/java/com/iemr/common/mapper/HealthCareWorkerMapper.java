package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.healthCareWorkerType.HealthCareWorker;
import com.iemr.common.model.user.HealthCareWorkerModel;

@Mapper(componentModel = "spring")
@DecoratedWith(HealthCareWorkerMapperDecorator.class)

public interface HealthCareWorkerMapper
{
	HealthCareWorkerMapper INSTANCE = Mappers.getMapper(HealthCareWorkerMapper.class);

	HealthCareWorkerModel getModelByWorker(HealthCareWorker worker);

	@IterableMapping(elementTargetType = HealthCareWorkerModel.class)
	List<HealthCareWorkerModel> getModelByWorker(List<HealthCareWorker> worker);

	HealthCareWorkerModel getModelByWorkerID(Short workerID);

	@IterableMapping(elementTargetType = HealthCareWorkerModel.class)
	List<HealthCareWorkerModel> getModelByWorkerID(List<Short> worker);
}
