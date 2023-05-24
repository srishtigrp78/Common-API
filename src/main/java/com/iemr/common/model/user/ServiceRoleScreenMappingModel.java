package com.iemr.common.model.user;

import lombok.Data;

@Data
public class ServiceRoleScreenMappingModel
{
	private Integer srsMappingID;// int(11) NO PRI auto_increment
	private Integer screenID;// int(11) YES MUL
	private ScreenModel screen;
	private Integer providerServiceMapID;
	private Integer roleID;
	private Boolean deleted;
}
