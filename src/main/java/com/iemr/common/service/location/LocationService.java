package com.iemr.common.service.location;


import java.util.List;

import com.iemr.common.data.location.CityDetails;
import com.iemr.common.data.location.Country;
import com.iemr.common.data.location.DistrictBlock;
import com.iemr.common.data.location.DistrictBranchMapping;
import com.iemr.common.data.location.Districts;
import com.iemr.common.data.location.States;

public interface LocationService {

	public List<States> getStates(int id);

	public List<Districts> getDistricts(int id);
	
	public List<Districts> findStateDistrictBy(int id);

	public List<DistrictBlock> getDistrictBlocks(int id);

	public abstract List<CityDetails> getCities(int id);

	public abstract List<DistrictBranchMapping> getDistrilctBranchs(int id);

	public List<Country> getCountries();
	
	//public Iterable<States> getDisricts();
	
	//public Iterable<States> getTalukas();
	
	//public Iterable<States> getVillages();
}
