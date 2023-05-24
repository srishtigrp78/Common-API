package com.iemr.common.service.swaasa;

import org.springframework.web.multipart.MultipartFile;

public interface SwaasaService {

	public String getSwaasaAdminLogin(String email, String password) throws Exception;

	public Boolean verifyCough(MultipartFile file, String authToken, Long patientId) throws Exception;

	String getAssesment(String assesmentId) throws Exception;

	String initiateAssesment(String request, MultipartFile file) throws Exception;

	public String getAssessmentDetails(Long patientId) throws Exception;

}
