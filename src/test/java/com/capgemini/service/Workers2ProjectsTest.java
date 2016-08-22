package com.capgemini.service;

import static org.junit.Assert.*;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.ProjectEntity;
import com.capgemini.domain.WorkerEntity;
import com.capgemini.domain.Workers2ProjectsEntity;
import com.capgemini.enums.Function;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class Workers2ProjectsTest {

	@Autowired
	private Workers2ProjectsService worker2projectService;

	@Autowired
	private WorkerService workerService;

	@Autowired
	private ProjectService projectService;

	@Test
	public void shouldAddWorker2Project() {
		
		//given
		String workerName = "Sebastiano";
		String workerSurname = "Amigo";
		Long projectId = 3L;
		Date dateSince = new Date();
		WorkerEntity worker = workerService.findWorkerByNameAndSurname(workerName, workerSurname).get(0);
		ProjectEntity project = projectService.findProjectById(projectId);
		Workers2ProjectsEntity worker2project = new Workers2ProjectsEntity(worker, project, Function.PL);
		worker2project.setDateSince(dateSince);
		worker2project.setDateTo(null);
		int countBefore = worker2projectService.findAllWorkers2Projects().size();
		
		//when
		worker2projectService.addWorkerToProject(worker2project);
		int countAfter = worker2projectService.findAllWorkers2Projects().size();
		
		//then
		assertEquals(countBefore + 1, countAfter);	
	}

	@Test
	public void shouldEndTestWithNull() throws Exception {
		
		//given
		Date dateOfEnd = new Date();
		Long id = 16L;
		Workers2ProjectsEntity worker2project = worker2projectService.findWorker2ProjectsById(id);
		
		//when
		worker2projectService.deleteWorkerFromProject(worker2project, dateOfEnd);
		Date dateTo = worker2projectService.findWorker2ProjectsById(id).getDateTo();
		
		//then
		assertEquals(dateOfEnd, dateTo);
	}
	
	@Test
	public void shouldEndTestWithDateAtTheEnd() throws Exception {
		
		//given
		Date dateOfEnd = new Date();
		Long id = 15L;
		Workers2ProjectsEntity worker2project = worker2projectService.findWorker2ProjectsById(id);
		
		//when
		worker2projectService.deleteWorkerFromProject(worker2project, dateOfEnd);
		Date dateTo = worker2projectService.findWorker2ProjectsById(id).getDateTo();
		
		//then
		assertEquals(dateOfEnd, dateTo);
	}
	
	@Test(expected = Exception.class)
	public void shouldNotEndTestWhereWorkerEndedJob() throws Exception {
		
		//given
		Date dateOfEnd = new Date();
		Long id = 8L;
		Workers2ProjectsEntity worker2project = worker2projectService.findWorker2ProjectsById(id);
		
		//when
		worker2projectService.deleteWorkerFromProject(worker2project, dateOfEnd);		
		//then
	
	}
	
	@Test
	public void shouldFindActualWorkersInProjects() {
		
		//given		
		String projectName = "projektB";
		int expectedNumberOfWorkers = 8;
		
		//when
		int numberOfWorkers = worker2projectService.findActualWorkersInProject(projectName).size();	
		
		//then
		assertEquals(expectedNumberOfWorkers, numberOfWorkers);
	}
	
	@Test
	public void shouldFindWorkersInProjectsInvolvingMoreThanXMonths() {
		
		//given		
		String projectName = "projektB";
		int numberOfMonths = 12;
		int expectedNumberOfWorkers = 8;
		
		//when
		int numberOfWorkers = worker2projectService.findWorkersInvolvedInProjectLongerThanXMonths(projectName, numberOfMonths).size();	
		
		//then
		assertEquals(expectedNumberOfWorkers, numberOfWorkers);
	}
}
