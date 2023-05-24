package com.iemr.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.users.User;
import com.iemr.common.model.user.ChangePasswordModel;
import com.iemr.common.model.user.LoginRequestModel;
import com.iemr.common.model.user.LoginResponseModel;

@Mapper(componentModel = "spring")
public interface UserMapper
{
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mappings({ @Mapping(source = "dto.userName", target = "userName"),
			@Mapping(source = "dto.password", target = "password") })
	User loginRequestToUser(LoginRequestModel dto);

	LoginResponseModel userDataToLoginResponse(User userData);
	
	User loginRequestToUser(ChangePasswordModel dto);
}
