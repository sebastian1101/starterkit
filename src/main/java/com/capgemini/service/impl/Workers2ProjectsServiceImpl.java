package com.capgemini.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.Worker2ProjectsDao;
import com.capgemini.domain.WorkerEntity;
import com.capgemini.domain.Workers2ProjectsEntity;
import com.capgemini.service.Workers2ProjectsService;

@Service
@Transactional(readOnly = false)
public class Workers2ProjectsServiceImpl implements Workers2ProjectsService {

	@Autowired
	private Worker2ProjectsDao worker2projects;

	@Override
	public Workers2ProjectsEntity addWorkerToProject(Workers2ProjectsEntity worker2project) {
		return worker2projects.save(worker2project);
	}

	@Override
	public List<Workers2ProjectsEntity> findAllWorkers2Projects() {
		return worker2projects.findAll();
	}

	@Override
	public Workers2ProjectsEntity deleteWorkerFromProject(Workers2ProjectsEntity worker2project, Date currentDate)
			throws Exception {

		Date dateOfEnd = worker2project.getDateTo();
		if(dateOfEnd == null) {			
			worker2project.setDateTo(currentDate);
			return worker2projects.update(worker2project);
		}
		boolean isEnded = dateOfEnd.getTime() < currentDate.getTime() ? true : false;
		if (dateOfEnd != null && isEnded) {
			throw new Exception("Worker has already ended his involvement in specified project.");
		}
		worker2project.setDateTo(currentDate);
		return worker2projects.update(worker2project);
	}

	@Override
	public Workers2ProjectsEntity findWorker2ProjectsById(Long id) {

		return worker2projects.findOne(id);
	}
	
	@Override
	public List<WorkerEntity> findActualWorkersInProject(String name) {
		
		return worker2projects.findActualWorkersInProject(name);
	}

	@Override
	public List<WorkerEntity> findWorkersInvolvedInProjectLongerThanXMonths(String projectName, int numberOfMonths) {
		return worker2projects.findWorkersInvolvedInProjectLongerThanXMonths(projectName, numberOfMonths);
	}
}
