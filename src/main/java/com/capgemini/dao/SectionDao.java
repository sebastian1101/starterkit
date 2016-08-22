package com.capgemini.dao;

import com.capgemini.domain.SectionEntity;


public interface SectionDao extends Dao<SectionEntity, Long> {
	
	SectionEntity findSectionByName(String sectionName);
}
