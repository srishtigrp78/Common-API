package com.iemr.common.service.helpline104history;

import java.util.ArrayList;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.iemr.common.repository.helpline104history.H104BenHistoryRepository;

@Service
public class H104BenHistoryServiceImpl implements H104BenHistoryService
{

	@Autowired
	private H104BenHistoryRepository smpleBenHistoryRepositoryRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Override
	public ArrayList<Objects[]> geSmpleBenHistory(Long beneficiaryId)
	{

		return smpleBenHistoryRepositoryRepository.getBenHistory(beneficiaryId);
	}

}
