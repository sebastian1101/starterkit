package com.capgemini.service;

import com.capgemini.domain.SectionEntity;

public interface SectionService {
	SectionEntity findSectionById(Long id);
	
	SectionEntity findSectionByName(String sectionName);

}
