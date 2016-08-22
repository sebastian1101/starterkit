package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.ProjectEntity;

public interface ProjectService {

	ProjectEntity saveProject(ProjectEntity project);
	
	void deleteProject(ProjectEntity project);
	
	ProjectEntity updateProject(ProjectEntity project);

	List<ProjectEntity> findAllProjects();

	ProjectEntity findProjectById(Long id);
	
}
