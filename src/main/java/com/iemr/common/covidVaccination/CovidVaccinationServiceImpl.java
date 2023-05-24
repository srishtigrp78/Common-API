package com.iemr.common.covidVaccination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;

@Service
public class CovidVaccinationServiceImpl implements CovidVaccinationService {

	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private CovidDoseTypeRepo covidDoseTypeRepo;

	@Autowired
	private CovidVaccineTypeRepo covidVaccineTypeRepo;

	@Autowired
	private CovidVaccinationRepo covidVaccinationRepo;

	@Override
	public String getVaccinationTypeAndDoseTaken() {
		Map<String, Object> responseMap = new HashMap<String, Object>();

		Iterable<CovidVaccineType> vaccineTypeList = new ArrayList<CovidVaccineType>();
		vaccineTypeList = covidVaccineTypeRepo.findAll();

		Iterable<CovidDoseType> doseTypeList = new ArrayList<CovidDoseType>();
		doseTypeList = covidDoseTypeRepo.findAll();

		responseMap.put("vaccineType", vaccineTypeList);
		responseMap.put("doseType", doseTypeList);

		return new Gson().toJson(responseMap);

	}

	@Override

	public String getCovidVaccinationDetails(Long benRegId) throws IEMRException {
		CovidVaccinationStatus benVaccinationDetails = new CovidVaccinationStatus();
		try {
			benVaccinationDetails = covidVaccinationRepo.findByBeneficiaryRegID(benRegId);
            if(benVaccinationDetails == null || benVaccinationDetails.getCovidVSID() == null)
            	return "No data found";
		} catch (Exception e) {
			logger.error(e.toString());

			throw new IEMRException(e.toString());
		}

		return new Gson().toJson(benVaccinationDetails);

	}

	/***
	 * 
	 */
	@Override
	public String saveBenCovidVaccinationDetails(String request) throws IEMRException {
		CovidVaccinationStatus covidVaccinationStatus = null;
		try {
			covidVaccinationStatus = InputMapper.gson().fromJson(request, CovidVaccinationStatus.class);
			if(covidVaccinationStatus != null && covidVaccinationStatus.getCovidVSID() != null) {
				covidVaccinationStatus.setProcessed("U");
			}
			covidVaccinationStatus = covidVaccinationRepo.save(covidVaccinationStatus);
			if (covidVaccinationStatus == null || covidVaccinationStatus.getCovidVSID() == null) {
				throw new IEMRException("Failed to save covid vaccination details");
			}
		} catch (Exception e) {
			logger.error(e.toString());
			throw new IEMRException(e.toString());
		}
		return new Gson().toJson(covidVaccinationStatus);
	}
}
