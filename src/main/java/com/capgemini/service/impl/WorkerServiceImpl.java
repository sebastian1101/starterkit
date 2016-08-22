package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.SectionDao;
import com.capgemini.dao.WorkerDao;
import com.capgemini.domain.SectionEntity;
import com.capgemini.domain.WorkerEntity;
import com.capgemini.service.WorkerService;

@Service
@Transactional(readOnly = true)
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	WorkerDao workerRepository;
	
	@Autowired
	SectionDao sectionRepository;
	
	@Override
	@Transactional(readOnly = false)
	public WorkerEntity saveWorker(WorkerEntity worker) {
		return workerRepository.save(worker);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteWorker(WorkerEntity worker) {
		workerRepository.delete(worker);
	}

	@Override
	@Transactional(readOnly = false)
	public WorkerEntity update(WorkerEntity worker) {
		return workerRepository.update(worker);
	}

	@Override@
	Transactional(readOnly = false)	
	public WorkerEntity assignToSection(String name, String surname, String sectionName) {
		
		SectionEntity section = sectionRepository.findSectionByName(sectionName);
		WorkerEntity worker = workerRepository.findWorkerByNameAndSurname(name, surname).get(0);
		worker.setSection(section);
		workerRepository.update(worker);
		
		return worker;
	}

	@Override
	public List<WorkerEntity> findWorkerByNameAndSurname(String name, String surname) {
		return workerRepository.findWorkerByNameAndSurname(name, surname);
	}

	@Override
	public List<WorkerEntity> findWorkerBySectionName(String sectionName) {
		return workerRepository.findWorkerBySectionName(sectionName);

	}
	
	@Override
	public List<WorkerEntity> findAllWorkers() {
		return workerRepository.findAll();

	}
	
}
