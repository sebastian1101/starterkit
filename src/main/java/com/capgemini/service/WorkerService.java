package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.WorkerEntity;

public interface WorkerService {
	
    WorkerEntity saveWorker(WorkerEntity worker);
    
    void deleteWorker(WorkerEntity worker);
    
    WorkerEntity update(WorkerEntity worker);
    
    WorkerEntity assignToSection(String name, String surname, String sectionName);
    
    List<WorkerEntity> findWorkerByNameAndSurname(String name, String surname);
	
	List<WorkerEntity> findWorkerBySectionName(String sectionName);

	List<WorkerEntity> findAllWorkers();

}
