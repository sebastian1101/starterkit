package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.WorkerEntity;
import com.capgemini.domain.Workers2ProjectsEntity;

public interface Worker2ProjectsDao extends Dao<Workers2ProjectsEntity, Long> {

	List<WorkerEntity> findActualWorkersInProject(String name);
	
	List<WorkerEntity> findWorkersInvolvedInProjectLongerThanXMonths(String projectName, int numberOfMonths);

	
}
