package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.ContactData;
import com.capgemini.domain.SectionEntity;
import com.capgemini.domain.WorkerEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class WorkerServiceTest {

	@Autowired
	private WorkerService workerService;
	
	@Autowired
	private SectionService sectionService;
	
	@Autowired
	private Workers2ProjectsService worker2projectService;
	
	@Autowired
	private EntityManager entityManager;
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testShouldSaveWorker() {
		// given
		
		int countBefore = workerService.findAllWorkers().size();
		final WorkerEntity worker = new WorkerEntity("Tadeusz", "Mrągowski", "39571847254");
		ContactData contactData = new ContactData("tmragowski@cg.pl","123 234 345","+48 725 937 576");
		String sectionName = "Ship";
		SectionEntity section = sectionService.findSectionByName(sectionName);
		
		worker.setBirthDate(new Date(1986, 8, 12));
		worker.setContactData(contactData);
		worker.setSection(section);
		
		// when
		WorkerEntity savedWorker = workerService.saveWorker(worker);
		// then
		assertNotNull(savedWorker.getId());
		assertEquals(countBefore + 1, workerService.findAllWorkers().size());
	}
	
	
	@Test
	public void testShouldFindWorkerBySectionName() {
		// given
		String sectionName = "Ship";
		int numberOfSectionMember = 2;
		
		// when
		final int numberOfWorkers = workerService.findWorkerBySectionName(sectionName).size();
		
		// then
		assertEquals(numberOfSectionMember , numberOfWorkers);
	}
	
	@Test
	public void testShouldFindWorkerByNameAndSurname() {
		// given
		String name = "Sebastian";
		String surname = "Tomczyk";
		
		// when
		List<WorkerEntity> workerList = workerService.findWorkerByNameAndSurname(name, surname);
		WorkerEntity worker = workerList.get(0);
		final int numberOfWorkers = workerList.size();
		
		// then
		assertEquals(1 , numberOfWorkers);
		assertEquals(name , worker.getName());
		assertEquals(surname , worker.getSurname());


	}
	
	@Test
	public void testShouldFindAllWorkers() {
		// given
		final int numberOfWorkers = 9;
		
		// when
		final int numberOfFoundWorkers = workerService.findAllWorkers().size();
		
		// then
		assertEquals(numberOfWorkers , numberOfFoundWorkers);
	} 
	
	
	@Test
	public void testShouldDeleteWorker() {
		
		// given
		String name = "Sebastian";
		String surname = "Tomczyk";
		int countBefore = workerService.findAllWorkers().size();
		final WorkerEntity workerToDelete = workerService.findWorkerByNameAndSurname(name, surname).get(0);
		int countBeforeWorker2ProjectAfter = worker2projectService.findAllWorkers2Projects().size();
		
		//when
		workerService.deleteWorker(workerToDelete);
		int countAfter = workerService.findAllWorkers().size();
		int countAfterWorker2ProjectAfter = worker2projectService.findAllWorkers2Projects().size();
		
		// then
		assertEquals(countBefore , countAfter + 1);
		assertEquals(countBeforeWorker2ProjectAfter , countAfterWorker2ProjectAfter + 2);

	}
	
	
	@Test
	public void testShouldUpdateWorkerData() {
		// given
		String name = "Sebastian";
		String surname = "Tomczyk";
		String newPesel = "77777777777";
		final WorkerEntity workerToUpdate = workerService.findWorkerByNameAndSurname(name, surname).get(0);
		workerToUpdate.setPesel(newPesel);
		
		
		// when
		WorkerEntity savedWorker = workerService.update(workerToUpdate);
		final WorkerEntity workerAfterUpdate = workerService.findWorkerByNameAndSurname(name, surname).get(0);
		// then
		assertNotNull(savedWorker.getId());
		assertEquals(workerAfterUpdate.getPesel() , newPesel);
	}
	
	
	@Test
	public void testShouldAssignToSection() {
		// given
		final String name = "Sebastian";
		final String surname = "Tomczyk";
		final String sectionName = "XPL";
		final SectionEntity sectionToAssign = sectionService.findSectionByName(sectionName);		
		
		// when
		workerService.assignToSection(name, surname, sectionName);
		final SectionEntity newSection = workerService.findWorkerByNameAndSurname(name, surname).get(0).getSection();
		
		// then
		assertEquals(sectionToAssign , newSection);
	}
	@Test(expected = OptimisticLockException.class)
	public void optimisticLockingTest() {
		
		// given
		String name = "Sebastiano";
		String surname = "Amigo";
		String newPesel = "77777777777";
		String newName = "Arkadiusz";
		
		final WorkerEntity workerWithFirstId = workerService.findWorkerByNameAndSurname(name, surname).get(0);
		entityManager.detach(workerWithFirstId);
		
		final WorkerEntity workerWithSecondId = workerService.findWorkerByNameAndSurname(name, surname).get(0);
		entityManager.detach(workerWithSecondId);
		
		//when
		workerWithFirstId.setPesel(newPesel);
		workerWithFirstId.setName(newName);
		
		entityManager.merge(workerWithFirstId);
		entityManager.flush();
		entityManager.merge(workerWithSecondId);
		
		//then

	}

}
