package com.iemr.common.service.lonic;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.iemr.common.utils.mapper.OutputMapper;
import com.iemr.common.data.lonic.LonicDescription;
import com.iemr.common.repository.lonic.LonicRepository;


@Service
@PropertySource("classpath:application.properties")
public class LonicServiceImpl implements LonicService {
	
	@Value("${lonicPageSize}")
	private Integer lonicPageSize;
	private LonicRepository lonicRepository;
	
	@Autowired
	public void setLonicRepository(LonicRepository lonicRepository) {
		this.lonicRepository = lonicRepository;
	}

	
	@Override
	public String findLonicRecordList(LonicDescription lonicDescription) throws Exception {
		
		Map<String, Object> dataMap = new HashMap<>();
		Page<LonicDescription> lonicList;
		if (lonicDescription != null && lonicDescription.getTerm() != null  && lonicDescription.getPageNo() != null) {
			
			PageRequest pr = new PageRequest(lonicDescription.getPageNo(), lonicPageSize);
			lonicList = lonicRepository.findLonicRecordList(lonicDescription.getTerm(),pr);

			dataMap.put("lonicMaster", lonicList.getContent());
			dataMap.put("pageCount", lonicList.getTotalPages());
			return OutputMapper.gson().toJson(dataMap);
		} else
			throw new Exception("invalid request");

	}

}
