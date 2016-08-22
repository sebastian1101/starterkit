package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.WorkerEntity;

public interface WorkerDao extends Dao<WorkerEntity, Long> {

	List<WorkerEntity> findWorkerByNameAndSurname(String name, String surname);
	
	List<WorkerEntity> findWorkerBySectionName(String sectionName);
	
}
