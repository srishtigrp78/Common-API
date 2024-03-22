package com.iemr.common.service.customization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.common.data.customization.ProjectCustomization;
import com.iemr.common.data.customization.ServicelineCustomization;
import com.iemr.common.repo.customization.ProjectCustomizationRepo;
import com.iemr.common.repo.customization.SectionMasterCustomizationRepo;
import com.iemr.common.repo.customization.ServicelineCustomizationRepo;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;

@Service
public class CustomizationServiceImpl implements CustomizationService {

	@Autowired
	private ProjectCustomizationRepo projectCustomizationRepo;
	@Autowired
	private SectionMasterCustomizationRepo sectionMasterCustomizationRepo;
	@Autowired
	private ServicelineCustomizationRepo servicelineCustomizationRepo;

	@Override
	public String addProject(String request, String Authorization) throws Exception {

		ProjectCustomization projectCustomization = InputMapper.gson().fromJson(request, ProjectCustomization.class);
		try {
			Set<ProjectCustomization> existingProjects = projectCustomizationRepo
					.findByProjectName(projectCustomization.getProjectName());
			if (existingProjects.isEmpty()) {
				projectCustomization.setDeleted(false);
				projectCustomizationRepo.save(projectCustomization);
				Map<String, Object> responseMap = new HashMap<>();
				responseMap.put("response", "Project Added Successfully");
				return new Gson().toJson(responseMap);
			} else {
				throw new IEMRException("project already exists");
			}
		} catch (IEMRException e) {
			throw new IEMRException(e.getMessage());
		}
	}

	@Override
	public String getProjectNames(Integer serviceProviderId) {
		ArrayList<ProjectCustomization> resultSet = projectCustomizationRepo.findByServiceProviderId(serviceProviderId);
		return new Gson().toJson(resultSet);
	}

	@Override
	public String validateProject(String request, String Authorization) throws Exception {
		ProjectCustomization projectCustomization = InputMapper.gson().fromJson(request, ProjectCustomization.class);
		try {
			Integer serviceProviderId = projectCustomizationRepo
					.findServiceProviderId(projectCustomization.getServiceProviderId());
			if (projectCustomization.getProjectId() != null && serviceProviderId != null) {
				projectCustomizationRepo.save(projectCustomization);
			}
			Map<String, Object> responseMap = new HashMap<>();
			responseMap.put("response", "Project validated Successfully");
			return new Gson().toJson(responseMap);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public String saveProjectToServiceline(String request, String Authorization) throws Exception {
		ServicelineCustomization servicelineCustomization = InputMapper.gson().fromJson(request, ServicelineCustomization.class);
		try {
			servicelineCustomization.setDeleted(false);
			servicelineCustomizationRepo.save(servicelineCustomization);
			Map<String, Object> responseMap = new HashMap<>();
			responseMap.put("response", "Save Project to Serviceline Successfully");
			return new Gson().toJson(responseMap);
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
