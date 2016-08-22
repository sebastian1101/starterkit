package com.capgemini.service;

import java.util.Date;
import java.util.List;

import com.capgemini.domain.WorkerEntity;
import com.capgemini.domain.Workers2ProjectsEntity;

public interface Workers2ProjectsService {

	Workers2ProjectsEntity addWorkerToProject(Workers2ProjectsEntity worker2project);

	List<Workers2ProjectsEntity> findAllWorkers2Projects();

	Workers2ProjectsEntity deleteWorkerFromProject(Workers2ProjectsEntity worker2project, Date currentDate) throws Exception;

	Workers2ProjectsEntity findWorker2ProjectsById(Long id);

	List<WorkerEntity> findActualWorkersInProject(String name);

	List<WorkerEntity> findWorkersInvolvedInProjectLongerThanXMonths(String projectName, int numberOfMonths);

}
