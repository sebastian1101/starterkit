package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.SectionDao;
import com.capgemini.domain.SectionEntity;
import com.capgemini.service.SectionService;

@Service
@Transactional(readOnly = true)
public class SectionServiceImpl  implements SectionService {

	@Autowired
	SectionDao sectionRepository;
	
	@Override
	public SectionEntity findSectionById(Long id) {
		return sectionRepository.findOne(id);
	}

	@Override
	public SectionEntity findSectionByName(String sectionName) {
		return sectionRepository.findSectionByName(sectionName);
	}
	
	

}
