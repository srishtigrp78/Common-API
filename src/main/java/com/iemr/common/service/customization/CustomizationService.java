package com.iemr.common.service.customization;

public interface CustomizationService {
	
	public String addProject(String request, String Authorization) throws Exception;
	
	public String getProjectNames(Integer serviceProviderId);
	
	public String validateProject(String request, String Authorization) throws Exception;
	
	public String saveProjectToServiceline(String request, String Authorization) throws Exception;
	
}
