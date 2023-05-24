package com.iemr.common.service.institute;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.institute.Institute;
import com.iemr.common.repository.institute.InstituteRepository;

@Service
public class InstituteServiceImpl implements InstituteService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	InstituteRepository instituteRepository;

	@Autowired
	public void setInstituteRepository(InstituteRepository instituteRepository) {
		this.instituteRepository = instituteRepository;
	}

	@Override
	public List<Institute> getInstitutesByStateDistrictBranch(Integer stateID, Integer districtID, Integer districtBranchID) {
		ArrayList<Institute> institutes = new ArrayList<Institute>();
		Set<Objects[]> instituteResult = instituteRepository.findAciveInstitutesByStateDistBlockID(stateID, districtID,
				districtBranchID);
		for (Object[] objects : instituteResult) {
			if (objects != null && objects.length == 2) {
				institutes.add(new Institute((Integer) objects[0], (String) objects[1]));
			}
		}
		logger.info("getInstitutesByLocation response size" +  (institutes.size() > 0 ? institutes.size() : "No Beneficiary Found") );
		return institutes;
	}

	@Override
	public List<Institute> getInstitutesByBranch(Integer districtBranchID) {
		ArrayList<Institute> institutes = new ArrayList<Institute>();
		Set<Objects[]> instituteResult = instituteRepository.findAciveInstitutesByBranchID(districtBranchID);
		for (Object[] objects : instituteResult) {
			if (objects != null && objects.length == 2) {
				institutes.add(new Institute((Integer) objects[0], (String) objects[1]));
			}
		}
		logger.info("getInstituteByBranch response size" + (institutes.size() > 0 ? institutes.size() : "No Beneficiary Found"));
		return institutes;
	}
}
