package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.ProjectDao;
import com.capgemini.domain.ProjectEntity;
import com.capgemini.service.ProjectService;

@Service
@Transactional(readOnly = false)
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectRepository;
	
	@Override
	public ProjectEntity saveProject(ProjectEntity project) {
		return projectRepository.save(project);
	}

	@Override
	public void deleteProject(ProjectEntity project) {
		projectRepository.delete(project);
	}

	@Override
	public ProjectEntity updateProject(ProjectEntity project) {
		return projectRepository.update(project);
	}

	@Override
	public List<ProjectEntity> findAllProjects() {
		return projectRepository.findAll();
	}
	
	@Override
	public ProjectEntity findProjectById(Long id) {
		
		return projectRepository.findOne(id);
	}
	
}
