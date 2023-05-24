package com.iemr.common.service.userbeneficiarydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.userbeneficiarydata.Title;
import com.iemr.common.repository.userbeneficiarydata.TitleRepository;

@Service
public class TitleServiceImpl implements TitleService {
	private TitleRepository titleRepository;

	@Autowired
	public void setTitleServiceImpl(TitleRepository titleRepository) {
		this.titleRepository = titleRepository;
	}

	public List<Title> getActiveTitles() {
		List<Title> activeTitles = new ArrayList<Title>();
		Set<Objects[]> lists = this.titleRepository.findAciveTitles();
		for (Object[] objects : lists) {
			if ((objects != null) && (objects.length == 3)) {
				activeTitles.add(new Title().getTitle(((Integer) objects[0]).intValue(), (String) objects[1]));
			}
		}
		return activeTitles;
	}
}
