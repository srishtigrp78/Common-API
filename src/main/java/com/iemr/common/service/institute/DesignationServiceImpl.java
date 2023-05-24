package com.iemr.common.service.institute;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.institute.Designation;
import com.iemr.common.repository.institute.DesignationRepository;

@Service
public class DesignationServiceImpl implements DesignationService {
	DesignationRepository designationRepository;

	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Autowired
	public void setDesignationRepository(DesignationRepository designationRepository) {
		this.designationRepository = designationRepository;
	}

	@Override
	public List<Designation> getDesignations() {
		List<Designation> designations = new ArrayList<Designation>();
		designations = designationRepository.findAciveDesignations();
		logger.info("getDesignations returning " + designations);
		return designations;
	}
}
