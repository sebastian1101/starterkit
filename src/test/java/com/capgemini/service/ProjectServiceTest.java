package com.capgemini.service;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.ProjectEntity;
import com.capgemini.enums.ProjectType;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProjectServiceTest {
	
	@Autowired
	ProjectService projectService;
	
	@Test
	public void shouldSaveProject() {
		
		//given
		int countBefore = projectService.findAllProjects().size();
		final ProjectEntity project = new ProjectEntity("NowyProjekt", ProjectType.inner ,260.0);
		
		//when
		projectService.saveProject(project);
		final int countAfter = projectService.findAllProjects().size();
		
		//then
		assertEquals(countBefore + 1, countAfter);
		
	}
	
	@Test
	public void shouldDeleteProject() {
		
		//given
		Long id = 1L;
		ProjectEntity projectToDelete = projectService.findProjectById(id);
		int countBefore = projectService.findAllProjects().size();

		//when
		projectService.deleteProject(projectToDelete);
		int countAfter = projectService.findAllProjects().size();
		
		//then
		assertEquals(countBefore, countAfter + 1);
		
	}
	
	@Test
	public void shouldUpdateProject() {
		
		//given
		Long id = 1L;
		String newName = "projektD";
		ProjectEntity projectToUpdate = projectService.findProjectById(id);
		
		//when
		projectToUpdate.setName(newName);
		projectService.updateProject(projectToUpdate);
		ProjectEntity projectAfterUpdate = projectService.findProjectById(id);
		
		//then
		assertEquals(newName, projectAfterUpdate.getName());
		
	}
	
	@Test
	public void shouldFindAllProjects() {
		
		//given
		final int numberOfProjects = 3;
		
		//when
		final int actualNumberOfProjects = projectService.findAllProjects().size();
		
		//then
		assertEquals(numberOfProjects, actualNumberOfProjects);
		
	}
	
	@Test
	public void shouldFindProjectsById() {
		
		//given
		final Long id = 1L;
		final String projectName = "projektA";
		final double salary = 23;
		ProjectType type = ProjectType.inner;
		
		//when
		final ProjectEntity project = projectService.findProjectById(id);
		
		//then
		assertEquals(projectName, project.getName());
		assertEquals(salary, project.getSalary(), 0);
		assertEquals(type, project.getType());

	}

}
