package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.callhandling.OutboundCallRequest;
import com.iemr.common.model.user.OutboundCallRequestModel;

@Mapper(componentModel = "spring")
public interface OutboundCallRequestMapper
{
	OutboundCallRequestMapper INSTANCE = Mappers.getMapper(OutboundCallRequestMapper.class);

	OutboundCallRequestModel outboundCallRequestToOutboundCallRequestModel(OutboundCallRequest outboundCallRequest);

	@IterableMapping(elementTargetType = OutboundCallRequestModel.class)
	List<OutboundCallRequestModel> outboundCallRequestToOutboundCallRequestModel(
			List<OutboundCallRequest> outboundCallRequest);
}
