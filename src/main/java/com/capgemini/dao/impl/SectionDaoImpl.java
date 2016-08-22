package com.capgemini.dao.impl;


import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.SectionDao;
import com.capgemini.domain.SectionEntity;

@Repository
public class SectionDaoImpl extends AbstractDao<SectionEntity, Long> implements SectionDao  {
	
	@Override
	public SectionEntity findSectionByName(String sectionName) {

		TypedQuery<SectionEntity> query = entityManager
				.createNamedQuery("sectionEntity.findSectionByName", SectionEntity.class);
		query.setParameter("sectionName", sectionName);
		return query.getSingleResult();

	}
	
}
