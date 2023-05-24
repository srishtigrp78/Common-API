package com.iemr.common.covidVaccination;

import com.iemr.common.utils.exception.IEMRException;

public interface CovidVaccinationService {

	public String getVaccinationTypeAndDoseTaken() throws IEMRException;

	public String saveBenCovidVaccinationDetails(String request) throws IEMRException;

	public String getCovidVaccinationDetails(Long benRegId) throws IEMRException;

}
