package com.iemr.common.service.scheme;

import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Pageable;

import com.iemr.common.data.scheme.Scheme;


public interface SchemeService {
	List<Scheme> getSchemeList(Integer providerServiceMapID) throws Exception;
	Scheme getSchemeByID(Integer schemeID) throws Exception;	
	public String deletedata(Scheme deleteData);
	public Scheme save(Scheme scheme) throws Exception;
	
}
