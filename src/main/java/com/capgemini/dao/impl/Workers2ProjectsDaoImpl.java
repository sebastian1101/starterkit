package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.Worker2ProjectsDao;
import com.capgemini.domain.WorkerEntity;
import com.capgemini.domain.Workers2ProjectsEntity;

@Repository
public class Workers2ProjectsDaoImpl extends AbstractDao<Workers2ProjectsEntity, Long> implements Worker2ProjectsDao {

	@Override
	public List<WorkerEntity> findActualWorkersInProject(String name) {
		
		TypedQuery<WorkerEntity> query = entityManager.createNamedQuery("workers2projects.findActualWorkersInProject",WorkerEntity.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

	@Override
	public List<WorkerEntity> findWorkersInvolvedInProjectLongerThanXMonths(String projectName, int numberOfMonths) {
		
		TypedQuery<WorkerEntity> query = entityManager.createNamedQuery("workers2projects.findWorkersInvolvedLongerThanXMonthsInProject",WorkerEntity.class);
		query.setParameter("name", projectName).setParameter("nMonth", numberOfMonths);
		return query.getResultList();
		
	}

	
	
	

}
