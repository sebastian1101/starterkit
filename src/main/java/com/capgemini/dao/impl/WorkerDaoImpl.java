package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.WorkerDao;
import com.capgemini.domain.WorkerEntity;

@Repository
public class WorkerDaoImpl extends AbstractDao<WorkerEntity, Long> implements WorkerDao {

	@Override
	public List<WorkerEntity> findWorkerByNameAndSurname(String name, String surname) {
		TypedQuery<WorkerEntity> query = entityManager.createQuery(
				"select worker from WorkerEntity worker where upper(worker.name) like concat(upper(:name), '%') and upper(worker.surname) like concat(upper(:surname), '%')",
				WorkerEntity.class);
		query.setParameter("name", name).setParameter("surname", surname);
		return query.getResultList();
	}

	@Override
	public List<WorkerEntity> findWorkerBySectionName(String sectionName) {

		TypedQuery<WorkerEntity> query = entityManager.createNamedQuery("worker.findWorkerBySectionName",WorkerEntity.class);
		query.setParameter("sectionName", sectionName);
		return query.getResultList();

	}
}
