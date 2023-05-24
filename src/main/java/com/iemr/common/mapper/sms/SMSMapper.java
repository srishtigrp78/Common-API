package com.iemr.common.mapper.sms;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.sms.SMSParameters;
import com.iemr.common.data.sms.SMSParametersMap;
import com.iemr.common.data.sms.SMSTemplate;
import com.iemr.common.data.sms.SMSType;
import com.iemr.common.model.sms.CreateSMSRequest;
import com.iemr.common.model.sms.FullSMSTemplateResponse;
import com.iemr.common.model.sms.SMSParameterMapModel;
import com.iemr.common.model.sms.SMSParameterModel;
import com.iemr.common.model.sms.SMSRequest;
import com.iemr.common.model.sms.SMSTemplateResponse;
import com.iemr.common.model.sms.SMSTypeModel;
import com.iemr.common.model.sms.UpdateSMSRequest;

@Mapper(componentModel = "spring")
public interface SMSMapper
{

	SMSMapper INSTANCE = Mappers.getMapper(SMSMapper.class);

	@Mappings({ @Mapping(source = "request.smsTemplateTypeID", target = "smsTypeID"), })
	SMSTemplate requestToSMSTemplate(SMSRequest request);

	@IterableMapping(elementTargetType = SMSTemplate.class)
	List<SMSTemplate> requestToSMSTemplate(List<SMSRequest> smsRequests);

	SMSTemplateResponse smsTemplateToResponse(SMSTemplate smsTemplate);

	@IterableMapping(elementTargetType = SMSTemplateResponse.class)
	List<SMSTemplateResponse> smsTemplateToResponse(List<SMSTemplate> smsTemplates);

	SMSTemplate updateRequestToSMSTemplate(UpdateSMSRequest updateSMSRequest);

	@IterableMapping(elementTargetType = SMSTemplate.class)
	List<SMSTemplate> updateRequestToSMSTemplate(List<UpdateSMSRequest> updateSMSRequests);

	SMSTemplate createRequestToSMSTemplate(CreateSMSRequest createSMSRequest);

	@IterableMapping(elementTargetType = SMSTemplate.class)
	List<SMSTemplate> createRequestToSMSTemplate(List<CreateSMSRequest> createSMSRequests);

	SMSType smsTypeModelToSMSType(SMSTypeModel smsTypeModel);

	@IterableMapping(elementTargetType = SMSType.class)
	List<SMSType> smsTypeModelToSMSType(List<SMSTypeModel> smsTypeModels);

	SMSTypeModel smsTypeToSMSTypeModel(SMSType smsType);

	@IterableMapping(elementTargetType = SMSTypeModel.class)
	List<SMSTypeModel> smsTypeToSMSTypeModel(List<SMSType> smsTypes);

	SMSParametersMap smsParameterMapModelToSMSParametersMap(SMSParameterMapModel smsParameterMapModel);

	@IterableMapping(elementTargetType = SMSParametersMap.class)
	List<SMSParametersMap> smsParameterMapModelToSMSParametersMap(List<SMSParameterMapModel> smsParameterMapModels);

	@Mappings({
			@Mapping(target = "smsParameterType",
					expression = "java(smsParametersMap.getSmsParameter().getSmsParameterType())"),
			@Mapping(target = "smsParameterValue",
					expression = "java(smsParametersMap.getSmsParameter().getSmsParameterName())"),
			@Mapping(target = "smsParameterName", expression = "java(smsParametersMap.getSmsParameterName())"), })
	SMSParameterMapModel smsParametersMapToSMSParameterMapModel(SMSParametersMap smsParametersMap);

	@IterableMapping(elementTargetType = SMSParameterMapModel.class)
	List<SMSParameterMapModel> smsParametersMapToSMSParameterMapModel(List<SMSParametersMap> smsParametersMaps);

	SMSParameters smsParameterModelToSMSParameters(SMSParameterModel smsParameterModel);

	@IterableMapping(elementTargetType = SMSParameters.class)
	List<SMSParameters> smsParameterModelToSMSParameters(List<SMSParameterModel> smsParameterModels);

	SMSParameterModel smsParametersToSMSParameterModel(SMSParameters smsParameter);

	@IterableMapping(elementTargetType = SMSParameterModel.class)
	List<SMSParameterModel> smsParametersToSMSParameterModel(List<SMSParameters> smsParameters);

	FullSMSTemplateResponse smsTemplateToFullResponse(SMSTemplate smsTemplate);

	@IterableMapping(elementTargetType = FullSMSTemplateResponse.class)
	List<FullSMSTemplateResponse> smsTemplateToFullResponse(List<SMSTemplate> smsTemplate);

}
